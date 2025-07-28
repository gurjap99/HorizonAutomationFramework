#!/bin/bash

# Cross-platform test runner for Cucumber + Allure
# Supports dynamic tag and feature file execution
# Uses fixed directories for report output

# Default values
CUCUMBER_TAG=${CUCUMBER_TAG:-""}
FEATURE_FILE=${FEATURE_FILE:-""}

# Clean previous results and reports
echo "Deleting previous Allure results and reports..."
rm -rf target/allure-results
rm -rf target/allure-report

# Construct Maven command
CMD="mvn clean test"

# Add tag filter if specified
if [ -n "$CUCUMBER_TAG" ]; then
  CMD="$CMD -Dcucumber.filter.tags=$CUCUMBER_TAG"
fi

# Add feature file if specified
if [ -n "$FEATURE_FILE" ]; then
  CMD="$CMD -Dcucumber.features=$FEATURE_FILE"
fi

# Run tests
echo "Running tests..."
eval $CMD

# Serve Allure report
echo "Serving Allure report..."
mvn allure:serve
