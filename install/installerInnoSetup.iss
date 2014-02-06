; Script generated by the Inno Setup Script Wizard.
; SEE THE DOCUMENTATION FOR DETAILS ON CREATING INNO SETUP SCRIPT FILES!

#define MyAppName "QSoftv2.4"
#define MyAppVersion "QSoft 2.4"
#define MyAppPublisher "SD3"
#define MyAppURL "http://www.sd3.fr/"
#define MyAppExeName "QSoftv2.4.exe"

[Setup]
; NOTE: The value of AppId uniquely identifies this application.
; Do not use the same AppId value in installers for other applications.
; (To generate a new GUID, click Tools | Generate GUID inside the IDE.)
AppId={{E73856D2-7FB6-4AF5-8B1D-4FEDCDE10813}
AppName={#MyAppName}
AppVersion={#MyAppVersion}
;AppVerName={#MyAppName} {#MyAppVersion}
AppPublisher={#MyAppPublisher}
AppPublisherURL={#MyAppURL}
AppSupportURL={#MyAppURL}
AppUpdatesURL={#MyAppURL}
DefaultDirName={pf}\{#MyAppName}
DefaultGroupName={#MyAppName}
OutputDir=C:\Users\IT SD3\workspace\QSoftv2.3\install
OutputBaseFilename=QSoftSetup
Compression=lzma
SolidCompression=yes

[Languages]
Name: "english"; MessagesFile: "compiler:Default.isl"
Name: "dutch"; MessagesFile: "compiler:Languages\Dutch.isl"
Name: "french"; MessagesFile: "compiler:Languages\French.isl"
Name: "german"; MessagesFile: "compiler:Languages\German.isl"
Name: "italian"; MessagesFile: "compiler:Languages\Italian.isl"

[Tasks]
Name: "desktopicon"; Description: "{cm:CreateDesktopIcon}"; GroupDescription: "{cm:AdditionalIcons}"; Flags: unchecked

[Files]
;Source: "C:\Documents and Settings\stage\Bureau\Test QsoftInstall\QSoftv2.3\install\QSoftv2.4.exe"; DestDir: "{app}"; Permissions : users-modify; Flags: ignoreversion
;Source: "C:\Documents and Settings\stage\Bureau\Test QsoftInstall\QSoftv2.3\install\jre1.6.0_02\*"; DestDir: "{app}"; Permissions : users-modify; Flags: ignoreversion recursesubdirs createallsubdirs
;Source: "C:\Documents and Settings\stage\Bureau\Test QsoftInstall\QSoftv2.3\install\*"; DestDir: "{app}"; Permissions : users-modify; Flags: ignoreversion recursesubdirs createallsubdirs
;Source: "C:\Documents and Settings\stage\Bureau\Test QsoftInstall\QSoftv2.3\*"; DestDir: "{app}"; Permissions : users-modify; Flags: ignoreversion recursesubdirs createallsubdirs
Source: "*"; DestDir: "{app}"; Flags: ignoreversion recursesubdirs createallsubdirs
; NOTE: Don't use "Flags: ignoreversion" on any shared system files

[Icons]
Name: "{group}\{#MyAppName}"; Filename: "{app}\{#MyAppExeName}"
Name: "{group}\{cm:UninstallProgram,{#MyAppName}}"; Filename: "{uninstallexe}"
Name: "{commondesktop}\{#MyAppName}"; Filename: "{app}\{#MyAppExeName}"; Tasks: desktopicon

[Run]
Filename: "{app}\{#MyAppExeName}"; Description: "{cm:LaunchProgram,{#StringChange(MyAppName, "&", "&&")}}"; Flags: nowait postinstall skipifsilent

