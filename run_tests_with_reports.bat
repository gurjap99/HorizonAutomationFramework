@echo off
REM Clean up previous Allure results and reports
IF EXIST target\allure-results rd /s /q target\allure-results
IF EXIST target\allure-report rd /s /q target\allure-report

REM Default values
set "CUCUMBER_TAG=%~1"
set "FEATURE_FILE=%~2"

REM Construct Maven command
set "CMD=mvn clean test"

REM Add tag filter if specified
if not "%CUCUMBER_TAG%"=="" (
    set "CMD=%CMD% -Dcucumber.filter.tags=%CUCUMBER_TAG%"
)

REM Add feature file if specified
if not "%FEATURE_FILE%"=="" (
    set "CMD=%CMD% -Dcucumber.features=%FEATURE_FILE%"
)

REM Run tests
echo Running tests...
call %CMD%

REM Generate Allure report
echo Generating Allure report...
call mvn allure:report

REM Open report
echo Opening Allure report...
call mvn allure:serve
