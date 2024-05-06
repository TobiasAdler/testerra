# Workflow-files

## `framework-test.yml`

* just one job, nothing in parallel
* artifacts (reports) are uploaded in zip files
* works, but takes ~24:30 to finish

## `framework-test-2.yml`

* works and publishes reports in zip files
* 2 jobs (`test-reportng` and `test-testerra`)
* both have to execute the pretests, but only `test-testerra` uploads the pretest results to GitHub
* takes about 15:09 to finish, the latest and right now the best and fastest solution

## `framework-test-3.yml`

* 3 jobs: `test-reportng` and `test-testerra` depend on `generate-pre-test-reports`
* goal: remove redundant execution of pretests
* `generate-pre-test-reports` executes pretests, generates reports and uploads them
* `test-reportng` and `test-testerra` download the zips and use the results so that in these steps, the pretests don't
  have to be run
* issue with failing `integration-tests` that use the generated and downloaded reports, cause currently unknown

## `framework-test-backup.yml`
* workflow for testing the `html-reporter-github-pages` action
* does not work at the moment

## `framework-test-with-report-publishing.yml`

* unfinished workflow for testing purposes
* contains just the `Prepare Status Tests`- part and tries to publish the report using GitHub pages
* does not work as expected at the moment, the report cannot properly be published to GitHub pages because of an error from the `html-reporter-github-pages` action
