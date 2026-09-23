# Rollback Runbook

## Artifact rollback
1. Open the last successful Jenkins build.
2. Download the archived WAR artifact.
3. Stop Tomcat if required by the environment.
4. Replace the current WAR in `webapps` with the previous successful WAR.
5. Start/reload Tomcat.
6. Verify `/health` returns HTTP 200 and `OK`.

## Git rollback
1. Identify the previous known-good commit.
2. Revert the faulty commit using `git revert <commit-sha>`.
3. Push the revert commit.
4. Re-run the Jenkins pipeline.
5. Verify the application and health endpoint.
