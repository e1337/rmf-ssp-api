-- -----------------------------------------------------
-- Schema RMF
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `RMF` ;

-- -----------------------------------------------------
-- Schema RMF
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `RMF` ;
USE `RMF` ;

-- -----------------------------------------------------
-- Table `RMF`.`controls`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `RMF`.`controls` ;

CREATE TABLE IF NOT EXISTS `RMF`.`controls` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `family_name` VARCHAR(255) NOT NULL,
  `family_number` VARCHAR(255) NOT NULL,
  `family_abbrv` VARCHAR(255) NOT NULL,
  `title` VARCHAR(255) NOT NULL,
  `priority` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`));

CREATE UNIQUE INDEX `family_number_UNIQUE` ON `RMF`.`controls` (`family_number` ASC);


-- -----------------------------------------------------
-- Table `RMF`.`control_enhancements`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `RMF`.`control_enhancements` ;

CREATE TABLE IF NOT EXISTS `RMF`.`control_enhancements` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `control_id` INT NOT NULL,
  `family_number` VARCHAR(255) NOT NULL,
  `title` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `control_enhancements_fk0`
    FOREIGN KEY (`control_id`)
    REFERENCES `RMF`.`controls` (`id`));

CREATE INDEX `control_enhancements_fk0` ON `RMF`.`control_enhancements` (`control_id` ASC);


-- -----------------------------------------------------
-- Table `RMF`.`objectives`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `RMF`.`objectives` ;

CREATE TABLE IF NOT EXISTS `RMF`.`objectives` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `control_id` INT NULL DEFAULT NULL,
  `control_enhancement_id` INT NULL DEFAULT NULL,
  `decision` VARCHAR(8192) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `objectives_fk0`
    FOREIGN KEY (`control_id`)
    REFERENCES `RMF`.`controls` (`id`),
  CONSTRAINT `objectives_fk1`
    FOREIGN KEY (`control_enhancement_id`)
    REFERENCES `RMF`.`control_enhancements` (`id`));

CREATE INDEX `objectives_fk0` ON `RMF`.`objectives` (`control_id` ASC);

CREATE INDEX `objectives_fk1` ON `RMF`.`objectives` (`control_enhancement_id` ASC);


-- -----------------------------------------------------
-- Table `RMF`.`objectives_sub`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `RMF`.`objectives_sub` ;

CREATE TABLE IF NOT EXISTS `RMF`.`objectives_sub` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `objective_id` INT NOT NULL,
  `number` VARCHAR(255) NOT NULL,
  `decision` VARCHAR(8192) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `objectives_sub_fk0`
    FOREIGN KEY (`objective_id`)
    REFERENCES `RMF`.`objectives` (`id`));

CREATE INDEX `objectives_sub_fk0` ON `RMF`.`objectives_sub` (`objective_id` ASC);


-- -----------------------------------------------------
-- Table `RMF`.`objectives_sub_sub`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `RMF`.`objectives_sub_sub` ;

CREATE TABLE IF NOT EXISTS `RMF`.`objectives_sub_sub` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `objective_sub_id` INT NOT NULL,
  `number` VARCHAR(255) NOT NULL,
  `decision` VARCHAR(8192) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `objectives_sub_sub_fk0`
    FOREIGN KEY (`objective_sub_id`)
    REFERENCES `RMF`.`objectives_sub` (`id`));

CREATE INDEX `objectives_sub_sub_fk0` ON `RMF`.`objectives_sub_sub` (`objective_sub_id` ASC);


-- -----------------------------------------------------
-- Table `RMF`.`potential_assessments`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `RMF`.`potential_assessments` ;

CREATE TABLE IF NOT EXISTS `RMF`.`potential_assessments` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `controls_id` INT NOT NULL,
  `method` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `potential_assessments_fk0`
    FOREIGN KEY (`controls_id`)
    REFERENCES `RMF`.`controls` (`id`));

CREATE INDEX `potential_assessments_fk0` ON `RMF`.`potential_assessments` (`controls_id` ASC);


-- -----------------------------------------------------
-- Table `RMF`.`potential_assessment_objects`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `RMF`.`potential_assessment_objects` ;

CREATE TABLE IF NOT EXISTS `RMF`.`potential_assessment_objects` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `potential_assessment_id` INT NOT NULL,
  `object` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `potential_assessment_objects_fk0`
    FOREIGN KEY (`potential_assessment_id`)
    REFERENCES `RMF`.`potential_assessments` (`id`));

CREATE INDEX `potential_assessment_objects_fk0` ON `RMF`.`potential_assessment_objects` (`potential_assessment_id` ASC);


-- -----------------------------------------------------
-- Table `RMF`.`withdrawn`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `RMF`.`withdrawn` ;

CREATE TABLE IF NOT EXISTS `RMF`.`withdrawn` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `control_id` INT NULL,
  `control_enhancement_id` INT NULL,
  `incorporated_into` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `withdrawn_fk0`
    FOREIGN KEY (`control_id`)
    REFERENCES `RMF`.`controls` (`id`),
  CONSTRAINT `withdrawn_fk1`
    FOREIGN KEY (`control_enhancement_id`)
    REFERENCES `RMF`.`control_enhancements` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE INDEX `withdrawn_fk0` ON `RMF`.`withdrawn` (`control_id` ASC);

CREATE INDEX `withdrawn_fk1_idx` ON `RMF`.`withdrawn` (`control_enhancement_id` ASC);


-- -----------------------------------------------------
-- Table `RMF`.`baseline_impacts`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `RMF`.`baseline_impacts` ;

CREATE TABLE IF NOT EXISTS `RMF`.`baseline_impacts` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `control_enhancement_id` INT NULL,
  `control_id` INT NULL,
  `baseline_impact_text` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `baseline_impacts_fk0`
    FOREIGN KEY (`control_enhancement_id`)
    REFERENCES `RMF`.`control_enhancements` (`id`),
  CONSTRAINT `baseline_impacts_fk1`
    FOREIGN KEY (`control_id`)
    REFERENCES `RMF`.`controls` (`id`));

CREATE INDEX `baseline_impacts_fk0` ON `RMF`.`baseline_impacts` (`control_enhancement_id` ASC);

CREATE INDEX `baseline_impacts_fk1` ON `RMF`.`baseline_impacts` (`control_id` ASC);


-- -----------------------------------------------------
-- Table `RMF`.`statements`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `RMF`.`statements` ;

CREATE TABLE IF NOT EXISTS `RMF`.`statements` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `control_id` INT NULL,
  `control_enhancement_id` INT NULL,
  `description` VARCHAR(8192) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `statements_fk0`
    FOREIGN KEY (`control_id`)
    REFERENCES `RMF`.`controls` (`id`),
  CONSTRAINT `statements_fk1`
    FOREIGN KEY (`control_enhancement_id`)
    REFERENCES `RMF`.`control_enhancements` (`id`));

CREATE INDEX `statements_fk0` ON `RMF`.`statements` (`control_id` ASC);

CREATE INDEX `statements_fk1` ON `RMF`.`statements` (`control_enhancement_id` ASC);


-- -----------------------------------------------------
-- Table `RMF`.`statements_sub`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `RMF`.`statements_sub` ;

CREATE TABLE IF NOT EXISTS `RMF`.`statements_sub` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `statement_id` INT NOT NULL,
  `control_id` INT NULL,
  `control_enhancement_id` INT NULL,
  `number` VARCHAR(255) NOT NULL,
  `description` VARCHAR(8192) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `statements_sub_fk0`
    FOREIGN KEY (`statement_id`)
    REFERENCES `RMF`.`statements` (`id`),
  CONSTRAINT `statements_sub_fk1`
    FOREIGN KEY (`control_id`)
    REFERENCES `RMF`.`statements` (`control_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `statements_sub_fk2`
    FOREIGN KEY (`control_enhancement_id`)
    REFERENCES `RMF`.`statements` (`control_enhancement_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE INDEX `statements_sub_fk0` ON `RMF`.`statements_sub` (`statement_id` ASC);

CREATE INDEX `statements_sub_fk2_idx` ON `RMF`.`statements_sub` (`control_enhancement_id` ASC);

CREATE INDEX `statements_sub_fk1_idx` ON `RMF`.`statements_sub` (`control_id` ASC);


-- -----------------------------------------------------
-- Table `RMF`.`statements_sub_sub`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `RMF`.`statements_sub_sub` ;

CREATE TABLE IF NOT EXISTS `RMF`.`statements_sub_sub` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `statement_sub_id` INT NOT NULL,
  `number` VARCHAR(255) NOT NULL,
  `description` VARCHAR(8192) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `statements_sub_sub_fk0`
    FOREIGN KEY (`statement_sub_id`)
    REFERENCES `RMF`.`statements_sub` (`id`));

CREATE INDEX `statements_sub_sub_fk0` ON `RMF`.`statements_sub_sub` (`statement_sub_id` ASC);


-- -----------------------------------------------------
-- Table `RMF`.`supplemental_guidance`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `RMF`.`supplemental_guidance` ;

CREATE TABLE IF NOT EXISTS `RMF`.`supplemental_guidance` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `control_id` INT NULL,
  `control_enhancement_id` INT NULL,
  `description` VARCHAR(8192) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `supplemental_guidance_fk0`
    FOREIGN KEY (`control_enhancement_id`)
    REFERENCES `RMF`.`control_enhancements` (`id`),
  CONSTRAINT `supplemental_guidance_fk1`
    FOREIGN KEY (`control_id`)
    REFERENCES `RMF`.`controls` (`id`));

CREATE INDEX `supplemental_guidance_fk0` ON `RMF`.`supplemental_guidance` (`control_enhancement_id` ASC);

CREATE INDEX `supplemental_guidance_fk1` ON `RMF`.`supplemental_guidance` (`control_id` ASC);


-- -----------------------------------------------------
-- Table `RMF`.`related_controls`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `RMF`.`related_controls` ;

CREATE TABLE IF NOT EXISTS `RMF`.`related_controls` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `supplemental_guidance_id` INT NOT NULL,
  `control_name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `related_controls_fk0`
    FOREIGN KEY (`supplemental_guidance_id`)
    REFERENCES `RMF`.`supplemental_guidance` (`id`));

CREATE INDEX `related_controls_fk0` ON `RMF`.`related_controls` (`supplemental_guidance_id` ASC);


-- -----------------------------------------------------
-- Table `RMF`.`references`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `RMF`.`references` ;

CREATE TABLE IF NOT EXISTS `RMF`.`references` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `control_id` INT NOT NULL,
  `description` VARCHAR(8192) NOT NULL,
  `link` VARCHAR(8192) NOT NULL,
  `language` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `references_fk0`
    FOREIGN KEY (`control_id`)
    REFERENCES `RMF`.`controls` (`id`));

CREATE INDEX `references_fk0` ON `RMF`.`references` (`control_id` ASC);
