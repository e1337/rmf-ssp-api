# rmf-ssp-api
Risk Management Framework Based on NIST 800-53 use in conjunction with e1337/rmf-ssp-web


The project aims to create a System Security Planning Web Service that exposes all the controls in NIST 800 53 rev4 as an API. Currently the project is already doing the fetching of NIST Controls via API Calls.

The project uses Springboot to start an h2 database, which stores the controls. In future it will have a more permanent database.

#### API End points

The following API Endpoints are implemented.

* http://127.0.0.1:8080/controls/id

`Returns a list of all controls.`

```[
    {
        "id": 1,
        "familyName": "ACCESS CONTROL",
        "familyNumber": "AC-1",
        "familyAbbrv": "AC",
        "title": "ACCESS CONTROL POLICY AND PROCEDURES",
        "priority": "P1"
    },
    {
        "id": 2,
        "familyName": "ACCESS CONTROL",
        "familyNumber": "AC-2",
        "familyAbbrv": "AC",
        "title": "ACCOUNT MANAGEMENT",
        "priority": "P1"
    },
   { "etc" : ".......and so on........."},
   {
        "id": 256,
        "familyName": "PROGRAM MANAGEMENT",
        "familyNumber": "PM-16",
        "familyAbbrv": "PM",
        "title": "THREAT AWARENESS PROGRAM",
        "priority": ""
    }
]
```
* http://127.0.0.1:8080/controls/id/227/details

`Returns details of the control and its enhancements.`

```{
       "id": 227,
       "familyName": "SYSTEM AND INFORMATION INTEGRITY",
       "familyNumber": "SI-4",
       "familyAbbrv": "SI",
       "title": "INFORMATION SYSTEM MONITORING",
       "priority": "P1",
       "withdrawn": [],
       "baselineImpacts": [
           "LOW",
           "MODERATE",
           "HIGH"
       ],
       "controlEnhancementStructures": [
           {
               "id": 632,
               "controlId": 227,
               "controlEnhancementId": null,
               "familyNumber": "SI-4 (24)",
               "title": "INDICATORS OF COMPROMISE",
               "baselineImpactsLists": [],
               "withdrawnList": [],
               "supplementalGuidanceStructureList": [
                   {
                       "supplementalGuidance": {
                           "id": 696,
                           "controlId": null,
                           "controlEnhancementId": 632,
                           "description": "Indicators of compromise (IOC) are forensic artifacts from intrusions that are identified on organizational information systems (at the host or network level). IOCs provide organizations with valuable information on objects or information systems that have been compromised. IOCs for the discovery of compromised hosts can include for example, the creation of registry key values. IOCs for network traffic include, for example, Universal Resource Locator (URL) or protocol elements that indicate malware command and control servers. The rapid distribution and adoption of IOCs can improve information security by reducing the time that information systems and organizations are vulnerable to the same exploit or attack."
                       },
                       "relatedControls": []
                   }
               ],
               "statementStructureList": [
                   {
                       "id": 835,
                       "controlId": 227,
                       "controlEnhancementId": null,
                       "description": "The organization:",
                       "statementSubStructures": [
                           {
                               "id": 551,
                               "statementId": 835,
                               "controlId": 227,
                               "controlEnhancementId": null,
                               "number": "SI-4c.",
                               "description": "Deploys monitoring devices:",
                               "statementsSubSub": [
                                   {
                                       "id": 149,
                                       "statementSubId": 551,
                                       "number": "SI-4c.1.",
                                       "description": "Strategically within the information system to collect organization-determined essential information; and"
                                   },
                                   {
                                       "id": 150,
                                       "statementSubId": 551,
                                       "number": "SI-4c.2.",
                                       "description": "At ad hoc locations within the system to track specific types of transactions of interest to the organization;"
                                   }
                               ]
                           },
                           {
                            ...
                           }
                       ]
                   }
               ]
           },
           {
            "...": "..."
           }
       ],
       "objectives": [],
       "objectivesSub": null,
       "objectivesSubSub": null,
       "potentialAssessments": null,
       "potentialAssessmentsObjects": null,
       "references": [
           {
               "id": 304,
               "controlId": 227,
               "description": "NIST Special Publication 800-61",
               "link": "http://csrc.nist.gov/publications/PubsSPs.html#800-61",
               "language": "en-US"
           },
           {
            ...
           }
       ],
       "statementStructureList": [
           {
               "id": 835,
               "controlId": 227,
               "controlEnhancementId": null,
               "description": "The organization:",
               "statementSubStructures": [
                   {
                       "id": 551,
                       "statementId": 835,
                       "controlId": 227,
                       "controlEnhancementId": null,
                       "number": "SI-4c.",
                       "description": "Deploys monitoring devices:",
                       "statementsSubSub": [
                           {
                               "id": 149,
                               "statementSubId": 551,
                               "number": "SI-4c.1.",
                               "description": "Strategically within the information system to collect organization-determined essential information; and"
                           },
                           {
                               "id": 150,
                               "statementSubId": 551,
                               "number": "SI-4c.2.",
                               "description": "At ad hoc locations within the system to track specific types of transactions of interest to the organization;"
                           }
                       ]
                   },
                  {...}
               ]
           }
       ],
       "supplementalGuidanceStructure": {
           "supplementalGuidance": {
               "id": 679,
               "controlId": 227,
               "controlEnhancementId": null,
               "description": "Information system monitoring includes external and internal monitoring. External monitoring includes the observation of events occurring at the information system boundary (i.e., part of perimeter defense and boundary protection). Internal monitoring includes the observation of events occurring within the information system. Organizations can monitor information systems, for example, by observing audit activities in real time or by observing other system aspects such as access patterns, characteristics of access, and other actions. The monitoring objectives may guide determination of the events. Information system monitoring capability is achieved through a variety of tools and techniques (e.g., intrusion detection systems, intrusion prevention systems, malicious code protection software, scanning tools, audit record monitoring software, network monitoring software). Strategic locations for monitoring devices include, for example, selected perimeter locations and near server farms supporting critical applications, with such devices typically being employed at the managed interfaces associated with controls SC-7 and AC-17. Einstein network monitoring devices from the Department of Homeland Security can also be included as monitoring devices. The granularity of monitoring information collected is based on organizational monitoring objectives and the capability of information systems to support such objectives. Specific types of transactions of interest include, for example, Hyper Text Transfer Protocol (HTTP) traffic that bypasses HTTP proxies. Information system monitoring is an integral part of organizational continuous monitoring and incident response programs. Output from system monitoring serves as input to continuous monitoring and incident response programs. A network connection is any connection with a device that communicates through a network (e.g., local area network, Internet). A remote connection is any connection with a device communicating through an external network (e.g., the Internet). Local, network, and remote connections can be either wired or wireless."
           },
           "relatedControls": [
               "AC-3",
                "..."
               "SI-7"
           ]
       }
   }

```

## Future Enhancements
1. Add database tables for Systems and components
2. Add API Endpoints to create System and components
3. Add database table for storing control assesment status and results for each system and components. 
4. Add API Endpoints to store the status of systems and component evaluation.
