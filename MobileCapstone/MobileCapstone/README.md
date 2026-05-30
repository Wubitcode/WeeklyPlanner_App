1. Introduction
Online scams are becoming more common through SMS messages, emails, fake job offers, phishing websites, and scam phone calls. Many users cannot easily recognize suspicious communication before financial or personal damage occurs.
This capstone project proposes a mobile application called CyberShield AI that helps users detect and analyze suspicious messages, links, and fake job offers. The application will work on both Android and iOS using React Native and Firebase.
The app will classify messages as Safe, Suspicious, or High Risk using rule-based scam detection and pattern analysis. It will also explain why content appears suspicious to improve cybersecurity awareness and help users better understand online scams.
2. General Functionality
The following are the core planned features for the application:
•	Cross-platform mobile app for Android and iOS
•	User-friendly interface designed in React Native
•	Paste and analyze suspicious messages
•	Fake job offer scam detection
•	Link and URL safety checker
•	Scam risk scoring system
•	Safe / Suspicious / High Risk classification
•	Explainable results showing why a message appears suspicious
•	Firebase backend integration
•	Store previous scan history
•	Scam awareness and cybersecurity tips section
•	Community scam phone number reporting (future enhancement)
•	Screenshot OCR scam analysis (future enhancement)
3. Technologies and Frameworks
The project will use the following technologies:
Technology	Purpose

React Native	              
            Cross-platform mobile app development
Firebase	              Backend database, authentication, cloud services
Firestore	              Store scam reports and scan history
JavaScript	              Detection logic and frontend functionality
GitHub	             Version control and project management
Expo	              Simplified mobile development and testing
4. Problem Being Solved
Many users receive scam messages every day but are unable to determine whether they are safe or dangerous. Scammers often create realistic fake job offers, banking alerts, delivery notifications, and account verification requests that pressure users into clicking malicious links or sending money.
CyberShield AI addresses this issue by giving users a mobile tool that analyzes suspicious communication and provides understandable explanations of scam indicators such as urgency, requests for money, suspicious links, impersonation, or emotional manipulation tactics.

5. Development Plan
The project will be developed incrementally using GitHub Projects and Agile development practices.
Planned Development Stages
1.	Requirement analysis and UI planning
2.	React Native project setup
3.	Firebase backend configuration
4.	Build message input and scanner screens
5.	Implement scam detection logic
6.	Add result explanations and risk scoring
7.	Add link checker functionality
8.	Testing and debugging
9.	Prepare final presentation and demo video

6. Expected Outcome
The expected outcome is a working mobile application prototype that demonstrates practical scam detection functionality and cybersecurity awareness features. The final prototype will allow users to test suspicious text messages and links while receiving understandable risk analysis and security recommendations.

This project will also strengthen skills in:
•	Mobile app development
•	React Native development
•	Firebase integration
•	Cybersecurity concepts
•	User interface design
•	Problem-solving and debugging

7. Conclusion
CyberShield AI is a cybersecurity-focused mobile application designed to help users identify and understand online scams using a simple and accessible interface. By combining scam detection logic, explainable analysis, and cross-platform mobile development, the application aims to provide a practical real-world solution for improving cybersecurity awareness and reducing scam-related risks for everyday users.

APP SCAFFOLDING LOOKS LIKE
CyberShieldAI/
│
├── app/
│   ├── screens/
│   │   ├── HomeScreen.js
│   │   ├── ScannerScreen.js
│   │   ├── ResultScreen.js
│   │   ├── LinkCheckerScreen.js
│   │   ├── FakeJobScreen.js
│   │   └── SettingsScreen.js
│   │
│   ├── components/
│   │   ├── RiskCard.js
│   │   ├── CustomButton.js
│   │   ├── ScanInput.js
│   │   └── Header.js
│   │
│   ├── navigation/
│   │   └── AppNavigator.js
│   │
│   ├── services/
│   │   ├── scamAnalyzer.js
│   │   ├── firebaseService.js
│   │   └── linkChecker.js
│   │
│   ├── firebase/
│   │   └── firebaseConfig.js
│   │
│   ├── utils/
│   │   ├── scoringSystem.js
│   │   └── helperFunctions.js
│   │
│   └── styles/
│       └── globalStyles.js
│
├── assets/
│   ├── images/
│   └── icons/
│
├── AIReflection.md
├── README.md
├── package.json
 |-----app-js


1 Scanner Screen Visual Wireframe (ScannerScreen.js)
 
=====================================================================
|| [☰]                   🛡️ CYBERSHIELD AI                   [👤] || [cite_start]<-- HEADER COMPONENT [cite: 75]
=====================================================================
||                                                                 ||
||  ✨ SECURE YOUR DIGITAL SPACE                                    ||
||  Paste an SMS, email, or job offer below to analyze risk.       [cite_start]|| [cite: 15]
||                                                                 ||
||  ┌── 📝 MESSAGE INPUT ────────────────────────────────────────┐  ||
||  │                                                            │  || [cite_start]<-- SCANINPUT COMPONENT [cite: 74]
||  │  "URGENT: Your account has been locked! Click the link     │  ||     (Dark Charcoal BG,
||  │   below immediately to verify your identity:               │  ||      White Text)
||  │   http://secure-login-382.com/auth"                        │  ||
||  │                                                            │  ||
||  └─────────────────────────────────────── [ 📋 Paste Text ] ─┘  ||
||                                                                 ||
||  ┌── ⚙️ SCAN CONFIGURATION ───────────────────────────────────┐  ||
||  │  (•) Heuristic Analysis        ( ) Deep AI Inspection      │  ||
||  └────────────────────────────────────────────────────────────┘  ||
||                                                                 ||
||  ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒ [ 🔍 RUN CYBER SHIELD SCAN ] ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒ || [cite_start]<-- CUSTOMBUTTON COMPONENT [cite: 73]
||                                                                     (Glowing Electric Blue)
||                                                                 ||
||  ┌── 💡 CYBERSECURITY TIP OF THE DAY ─────────────────────────┐  ||
||  [cite_start]│  "Legitimate financial institutions will never pressure    │  || <-- TIPS SECTION [cite: 23]
||  │   you into clicking unverified links via SMS text."       │  ||     (Emerald Green Text)
||  └────────────────────────────────────────────────────────────┘  ||
||                                                                 ||
=====================================================================
[cite_start]||  [🏠 Home]       ||  [🔍 Scan]       ||  [🔗 Links]  ||  [⚙️ Ops]  || <-- APP NAVIGATOR BAR [cite: 78]
=====================================================================


2 Threat Results Dashboard (ResultScreen.js)

=====================================================================
|| [◀ Back]                 📊 THREAT ANALYSIS                 [⚙️] || [cite_start]<-- HEADER COMPONENT [cite: 75]
=====================================================================
||                                                                 ||
||  🔴 CRITICAL THREAT DETECTED                                    ||
||                                                                 ||
||  █████████████████████████████████████████████████████████████  ||
||  █                                                           █  || [cite_start]<-- RISK CARD [cite: 72]
||  █                       ⚠️ HIGH RISK                         █  ||     (Flashing Neon Crimson
||  █                    THREAT SCORE: 94%                      █  ||      Background Block)
||  █                                                           █  ||
||  █████████████████████████████████████████████████████████████  ||
||                                                                 ||
||  [cite_start]📋 EXPLAINABLE SCAM INDICATORS:                                || [cite: 20]
||                                                                 ||
||  [cite_start]❌ High Urgency Flag Triggered                                 || [cite: 32]
||     - Keywords found: "URGENT", "immediately", "locked".        ||
||                                                                 ||
||  [cite_start]❌ Unverified URL Domain                                       || [cite: 32]
||     - "secure-login-382.com" is not a registered domain.       ||
||                                                                 ||
||  [cite_start]⚠️ Identity Spoofing Risk                                      || [cite: 32]
||     - Message structures mimic a formal bank alert layout.      ||
||                                                                 ||
||  ─────────────────────────────────────────────────────────────  ||
||                                                                 ||
||  ▒▒▒▒▒▒▒▒▒▒▒▒▒▒ [ 🛡️ Save to Threat History ] ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒  || [cite_start]<-- FIRESTORE INTERACTION [cite: 28]
||  ▒▒▒▒▒▒▒▒▒▒▒▒▒▒ [ ⬅️ Analyze New Content ] ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒  || [cite_start]<-- CUSTOMBUTTON COMPONENT [cite: 73]
||                                                                 ||
=====================================================================
