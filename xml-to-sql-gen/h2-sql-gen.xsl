<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:c="http://scap.nist.gov/schema/sp800-53/2.0"
    xmlns:controls="http://scap.nist.gov/schema/sp800-53/feed/2.0"
    xmlns:xhtml="http://www.w3.org/1999/xhtml"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://scap.nist.gov/schema/sp800-53/feed/2.0 http://scap.nist.gov/schema/sp800-53/feed/2.0/sp800-53-feed_2.0.xsd"
    version="2.0">
    <xsl:output method="text" omit-xml-declaration="yes" />
    
    <!-- <xsl:template match="c:statement"> -->
        <!-- <xsl:text>&#x9;</xsl:text> -->
        <!-- <xsl:value-of select="c:number"/> -->
        <!-- <xsl:text>&#x9;&#x9;&#x9;&#x9;</xsl:text> -->
        <!-- <xsl:text>"</xsl:text><xsl:value-of select="c:description"/><xsl:text>"</xsl:text> -->
        <!-- <xsl:text>&#xa;</xsl:text> -->
        <!-- <xsl:apply-templates select="c:statement"/> -->
    <!-- </xsl:template> -->

    <!-- <xsl:template name="control-info"> -->
        <!-- <xsl:text>&#x9;</xsl:text> -->
        <!-- <xsl:value-of select="c:number"/> -->
        <!-- <xsl:text>&#x9;</xsl:text> -->
        <!-- <xsl:value-of select="c:title"/> -->
        <!-- <xsl:text>&#x9;</xsl:text> -->
        <!-- <xsl:value-of select="c:priority"/> -->
        <!-- <xsl:text>&#x9;</xsl:text> -->
        <!-- <xsl:value-of select="string-join(c:baseline-impact,',')"/> -->
        <!-- <xsl:text>&#x9;</xsl:text> -->
        <!-- <xsl:text>"</xsl:text><xsl:value-of select="c:statement/c:description"/><xsl:text>"</xsl:text> -->
        <!-- <xsl:text>&#x9;</xsl:text> -->
        <!-- <xsl:if test="c:supplemental-guidance/c:description"> -->
            <!-- <xsl:text>"</xsl:text><xsl:value-of select="replace(c:supplemental-guidance/c:description, '&#xa;', ' ')"/><xsl:text>"</xsl:text> -->
        <!-- </xsl:if> -->
        <!-- <xsl:text>&#x9;</xsl:text> -->
        <!-- <xsl:value-of select="string-join(c:supplemental-guidance/c:related,',')"/> -->
    <!-- </xsl:template> -->
    
    <xsl:template match="/controls:controls">
        
        <xsl:for-each select="controls:control">
            <!-- Controls -->
			<!-- xsl:if withdrawn -->
			<xsl:variable name="family_name"><xsl:value-of select="c:family"/></xsl:variable>
			
			<xsl:text>INSERT INTO CONTROLS ( FAMILY_NAME, FAMILY_NUMBER , FAMILY_ABBRV, TITLE , PRIORITY ) values ( '</xsl:text>
            <xsl:value-of select="c:family"/>
			<xsl:text>', '</xsl:text>
			<xsl:value-of select="c:number"/>
            <xsl:text>', '</xsl:text>
            <xsl:value-of select="substring(c:number,1,2)"/>
            <xsl:text>', '</xsl:text>
			<xsl:value-of select="c:title"/>
			<xsl:text>', '</xsl:text>
			<xsl:value-of select="c:priority"/>
			<xsl:text>' );&#xa;</xsl:text>
			
			<xsl:variable name="control_id">
				<xsl:text>( SELECT ID FROM CONTROLS WHERE FAMILY_NUMBER = '</xsl:text>
				<xsl:value-of select="c:number"/>
				<xsl:text>' )</xsl:text>
			</xsl:variable>
			
			<!-- INSERT INTO BASELINE_IMPACTS  ( CONTROL_ID , CONTROL_ENHANCEMENT_ID , BASELINE_IMPACT_TEXT ) VALUES (  SELECT ID FROM CONTROLS WHERE FAMILY_NUMBER  = 'AC-13' ,NULL ,'impact') -->
			<xsl:for-each select="c:baseline-impact">
				<xsl:text>INSERT INTO BASELINE_IMPACTS  ( CONTROL_ID , CONTROL_ENHANCEMENT_ID , BASELINE_IMPACT_TEXT ) VALUES ( </xsl:text>
				<xsl:value-of select ="$control_id"/>
				<xsl:text>, NULL , '</xsl:text>
				<xsl:value-of select = "text()"/>
				<xsl:text>' );&#xa;</xsl:text>
			</xsl:for-each>
			
			<!--INSERT INTO STATEMENTS ( CONTROL_ID ,CONTROL_ENHANCEMENT_ID ,DESCRIPTION ) VALUES (  SELECT ID FROM CONTROLS WHERE "FAMILY_NUMBER" = 'AC-1' ,NULL,'description')-->
			<xsl:for-each select="c:statement">
				<xsl:text>INSERT INTO STATEMENTS ( CONTROL_ID, CONTROL_ENHANCEMENT_ID, DESCRIPTION ) VALUES (</xsl:text>
				<xsl:value-of select ="$control_id"/>
				<xsl:text>, NULL , '</xsl:text>
				<xsl:value-of select="c:description"/>
				<xsl:text>' );&#xa;</xsl:text>
				<xsl:variable name="statement_id">
					<xsl:text>(SELECT ID FROM STATEMENTS WHERE CONTROL_ID = </xsl:text>
					<xsl:value-of select ="$control_id"/>
					<xsl:text>)</xsl:text>
				</xsl:variable>
				<xsl:for-each select="c:statement">
					<xsl:text>INSERT INTO STATEMENTS_SUB ( CONTROL_ID, STATEMENT_ID, CONTROL_ENHANCEMENT_ID, NUMBER, DESCRIPTION ) VALUES (</xsl:text>
					<xsl:value-of select ="$control_id"/>
					<xsl:text>, </xsl:text>
					<xsl:value-of select ="$statement_id"/>
					<xsl:text>, NULL , '</xsl:text>
					<xsl:value-of select="c:number"/>
					<xsl:text>' , '</xsl:text>
					<xsl:value-of select="c:description"/>
					<xsl:text>' );&#xa;</xsl:text>
					<xsl:variable name="statement_sub_id">
						<xsl:text>(SELECT ID FROM STATEMENTS_SUB WHERE NUMBER = '</xsl:text>
						<xsl:value-of select ="c:number"/>
						<xsl:text>' )</xsl:text>
					</xsl:variable>
					<xsl:for-each select="c:statement">
						<xsl:text>INSERT INTO STATEMENTS_SUB_SUB ( STATEMENT_SUB_ID, NUMBER, DESCRIPTION ) VALUES (</xsl:text>
						<xsl:value-of select ="$statement_sub_id"/>
						<xsl:text>, '</xsl:text>
						<xsl:value-of select="c:number"/>
						<xsl:text>' , '</xsl:text>
						<xsl:value-of select="c:description"/>
						<xsl:text>' );&#xa;</xsl:text>
					</xsl:for-each>					
				</xsl:for-each>
			</xsl:for-each>
			
			<!-- INSERT INTO SUPPLEMENTAL_GUIDANCE ( CONTROL_ID ,CONTROL_ENHANCEMENT_ID ,DESCRIPTION ) VALUES (  SELECT ID FROM CONTROLS WHERE "FAMILY_NUMBER" = 'AC-1' ,NULL,'description') -->
			<xsl:for-each select="c:supplemental-guidance">
				<xsl:text>INSERT INTO SUPPLEMENTAL_GUIDANCE ( CONTROL_ID ,CONTROL_ENHANCEMENT_ID ,DESCRIPTION ) VALUES ( </xsl:text>
				<xsl:value-of select ="$control_id"/>
				<xsl:text>, NULL ,'</xsl:text>
				<xsl:value-of select = "c:description"/>
				<xsl:text>' );&#xa;</xsl:text>
				<xsl:variable name="supplemental_guidance_id">
					<xsl:text>( SELECT ID FROM SUPPLEMENTAL_GUIDANCE WHERE CONTROL_ID = </xsl:text>
					<xsl:value-of select="$control_id"/>
					<xsl:text>)</xsl:text>
				</xsl:variable>
				<!-- INSERT INTO RELATED_CONTROLS  (  SUPPLEMENTAL_GUIDANCE_ID , CONTROL_NAME  ) VALUES (  SELECT ID FROM CONTROLS WHERE "FAMILY_NUMBER" = 'AC-1' ,NULL,'description') -->
				<xsl:for-each select="c:related">
					<xsl:text>INSERT INTO RELATED_CONTROLS ( SUPPLEMENTAL_GUIDANCE_ID , CONTROL_NAME ) VALUES (</xsl:text>
					<xsl:value-of select ="$supplemental_guidance_id"/>
					<xsl:text>, '</xsl:text>
					<xsl:value-of select = "text()"/>
					<xsl:text>' );&#xa;</xsl:text>
				</xsl:for-each>
			</xsl:for-each>
			
			<!-- INSERT INTO REFERENCES  (CONTROL_ID ,DESCRIPTION ,LINK ,LANGUAGE ) VALUES (  SELECT ID FROM CONTROLS WHERE "FAMILY_NUMBER" = 'AC-13' , 'description','link','lang') -->
			<xsl:for-each select="c:references/c:reference">
				<xsl:text>INSERT INTO REFERENCES (CONTROL_ID ,DESCRIPTION ,LANGUAGE ,LINK ) VALUES ( </xsl:text>
				<xsl:value-of select ="$control_id"/>
				<xsl:text>, '</xsl:text>
				<xsl:value-of select = "c:item/text()"/>
				<xsl:text>' , '</xsl:text>
				<xsl:value-of select ="c:item/@xml:lang"/>
				<xsl:text>' , '</xsl:text>
				<xsl:value-of select ="c:item/@href"/>
				<xsl:text>' );&#xa;</xsl:text>
			</xsl:for-each>
			
			<!-- INSERT INTO "WITHDRAWN" ( "CONTROL-ID", "INCORPORATED-INTO" ) VALUES (  SELECT ID FROM CONTROLS WHERE "FAMILY_NUMBER" = 'AC-13' , 'AC-2') -->
			<xsl:for-each select="c:withdrawn/c:incorporated-into">
				<xsl:text>INSERT INTO WITHDRAWN ( CONTROL_ID, CONTROL_ENHANCEMENT_ID , INCORPORATED_INTO ) VALUES (  </xsl:text>
				<xsl:value-of select ="$control_id"/>
				<xsl:text>, NULL ,'</xsl:text>
				<xsl:value-of select = "text()"/>
				<xsl:text>' );&#xa;</xsl:text>
			</xsl:for-each>

			<!-- INSERT INTO CONTROL_ENHANCEMENTS ( CONTROL_ID, FAMILY_NUMBER, TITLE ) VALUES (  SELECT ID FROM CONTROLS WHERE "FAMILY_NUMBER" = 'AC-1' ,'AC-1(1)','title') -->
			<xsl:for-each select="c:control-enhancements/c:control-enhancement">
				<xsl:text>INSERT INTO CONTROL_ENHANCEMENTS ( CONTROL_ID, FAMILY_NUMBER, TITLE ) VALUES ( </xsl:text>
				<xsl:value-of select ="$control_id"/>
				<xsl:text>, '</xsl:text>
				<xsl:value-of select = "c:number"/>
				<xsl:text>' , '</xsl:text>
				<xsl:value-of select ="c:title"/>
				<xsl:text>' );&#xa;</xsl:text>
				
				<xsl:variable name="control_enhancement_id">
					<xsl:text>(SELECT ID FROM CONTROL_ENHANCEMENTS WHERE FAMILY_NUMBER = '</xsl:text>
					<xsl:value-of select ="c:number"/>
					<xsl:text>')</xsl:text>
				</xsl:variable>
				
				<!-- INSERT INTO BASELINE_IMPACTS  ( CONTROL_ID , CONTROL_ENHANCEMENT_ID , BASELINE_IMPACT_TEXT ) VALUES (  SELECT ID FROM CONTROLS WHERE FAMILY_NUMBER  = 'AC-13' ,NULL ,'impact') -->
				<xsl:for-each select="c:baseline-impact">
					<xsl:text>INSERT INTO BASELINE_IMPACTS  ( CONTROL_ID , CONTROL_ENHANCEMENT_ID , BASELINE_IMPACT_TEXT ) VALUES ( </xsl:text>
					<xsl:text> NULL , </xsl:text>
					<xsl:value-of select ="$control_enhancement_id"/>
					<xsl:text>, '</xsl:text>
					<xsl:value-of select = "text()"/>
					<xsl:text>' );&#xa;</xsl:text>
				</xsl:for-each>
				
				<!--INSERT INTO STATEMENTS ( CONTROL_ID ,CONTROL_ENHANCEMENT_ID ,DESCRIPTION ) VALUES (  SELECT ID FROM CONTROLS WHERE "FAMILY_NUMBER" = 'AC-1' ,NULL,'description')-->
				<xsl:for-each select="c:statement">
					<xsl:text>INSERT INTO STATEMENTS ( CONTROL_ID, CONTROL_ENHANCEMENT_ID, DESCRIPTION ) VALUES (</xsl:text>
					<xsl:text> NULL , </xsl:text>
					<xsl:value-of select ="$control_enhancement_id"/>
					<xsl:text> , '</xsl:text>
					<xsl:value-of select="c:description"/>
					<xsl:text>' );&#xa;</xsl:text>
					<xsl:variable name="statement_id">
						<xsl:text>(SELECT ID FROM STATEMENTS WHERE CONTROL_ENHANCEMENT_ID = </xsl:text>
						<xsl:value-of select ="$control_enhancement_id"/>
						<xsl:text>)</xsl:text>
					</xsl:variable>
					<xsl:for-each select="c:statement">
						<xsl:text>INSERT INTO STATEMENTS_SUB ( CONTROL_ID, CONTROL_ENHANCEMENT_ID, STATEMENT_ID,  NUMBER, DESCRIPTION ) VALUES (</xsl:text>
						<xsl:text>NULL, </xsl:text>
						<xsl:value-of select ="$control_enhancement_id"/>
						<xsl:text> , </xsl:text>
						<xsl:value-of select ="$statement_id"/>
						<xsl:text> , '</xsl:text>
						<xsl:value-of select="c:number"/>
						<xsl:text>' , '</xsl:text>
						<xsl:value-of select="c:description"/>
						<xsl:text>' );&#xa;</xsl:text>
						<xsl:variable name="statement_sub_id">
							<xsl:text>(SELECT ID FROM STATEMENTS_SUB WHERE NUMBER = '</xsl:text>
							<xsl:value-of select ="c:number"/>
							<xsl:text>' )</xsl:text>
						</xsl:variable>
						<xsl:for-each select="c:statement">
							<xsl:text>INSERT INTO STATEMENTS_SUB_SUB ( STATEMENT_SUB_ID, NUMBER, DESCRIPTION ) VALUES (</xsl:text>
							<xsl:value-of select ="$statement_sub_id"/>
							<xsl:text>, '</xsl:text>
							<xsl:value-of select="c:number"/>
							<xsl:text>' , '</xsl:text>
							<xsl:value-of select="c:description"/>
							<xsl:text>' );&#xa;</xsl:text>
						</xsl:for-each>					
					</xsl:for-each>
				</xsl:for-each>
				
				<!-- INSERT INTO SUPPLEMENTAL_GUIDANCE ( CONTROL_ID ,CONTROL_ENHANCEMENT_ID ,DESCRIPTION ) VALUES (  SELECT ID FROM CONTROLS WHERE "FAMILY_NUMBER" = 'AC-1' ,NULL,'description') -->
				<xsl:for-each select="c:supplemental-guidance">
					<xsl:text>INSERT INTO SUPPLEMENTAL_GUIDANCE ( CONTROL_ID ,CONTROL_ENHANCEMENT_ID ,DESCRIPTION ) VALUES ( </xsl:text>
					<xsl:text>NULL, </xsl:text>
					<xsl:value-of select ="$control_enhancement_id"/>
					<xsl:text> , '</xsl:text>
					<xsl:value-of select = "c:description" />
					<xsl:text>' );&#xa;</xsl:text>
					<xsl:variable name="supplemental_guidance_id">
						<xsl:text>( SELECT ID FROM SUPPLEMENTAL_GUIDANCE WHERE CONTROL_ENHANCEMENT_ID = </xsl:text>
						<xsl:value-of select="$control_enhancement_id"/>
						<xsl:text>)</xsl:text>
					</xsl:variable>
					<!-- INSERT INTO RELATED_CONTROLS  (  SUPPLEMENTAL_GUIDANCE_ID , CONTROL_NAME  ) VALUES (  SELECT ID FROM CONTROLS WHERE "FAMILY_NUMBER" = 'AC-1' ,NULL,'description') -->
					<xsl:for-each select="c:related">
						<xsl:text>INSERT INTO RELATED_CONTROLS ( SUPPLEMENTAL_GUIDANCE_ID , CONTROL_NAME ) VALUES (</xsl:text>
						<xsl:value-of select ="$supplemental_guidance_id"/>
						<xsl:text>, '</xsl:text>
						<xsl:value-of select = "text()"/>
						<xsl:text>' );&#xa;</xsl:text>
					</xsl:for-each>
				</xsl:for-each>

				<!-- INSERT INTO WITHDRAWN  ( CONTROL_ID , CONTROL_ENHANCEMENT_ID , INCORPORATED_INTO ) VALUES (  NULL , SELECT ID FROM CONTROLS WHERE FAMILY_NUMBER  = 'SA-4' ,'impact') -->
				<xsl:for-each select="c:withdrawn/c:incorporated-into">
					<xsl:text>INSERT INTO WITHDRAWN ( CONTROL_ID, CONTROL_ENHANCEMENT_ID , INCORPORATED_INTO ) VALUES ( </xsl:text>
					<xsl:text> NULL , </xsl:text>
					<xsl:value-of select ="$control_enhancement_id"/>
					<xsl:text>, '</xsl:text>
					<xsl:value-of select = "text()"/>
					<xsl:text>' );&#xa;</xsl:text>
				</xsl:for-each>
			</xsl:for-each>

			<!-- <xsl:call-template name="control-info"/> -->
            <!-- <xsl:text>&#xa;</xsl:text> -->
            <!-- Statements -->
            <!-- <xsl:apply-templates select="c:statement/c:statement"/> -->
            <!-- Control Enhancements -->
            <!-- <xsl:for-each select="c:control-enhancements/c:control-enhancement"> -->
                <!-- <xsl:value-of select="$family"/> -->
                <!-- <xsl:call-template name="control-info"/> -->
                <!-- <xsl:text>&#xa;</xsl:text> -->
                <!-- <xsl:apply-templates select="c:statement/c:statement"/> -->
            <!-- </xsl:for-each> -->
        </xsl:for-each>
    </xsl:template>
</xsl:stylesheet>
