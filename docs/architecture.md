# Architecture

Developer -> GitHub -> Jenkins -> Maven Build/Test/Package -> WAR Artifact -> Tomcat -> Health Check -> Application

Quality gates:
- Unit-test failure stops the pipeline before deployment.
- Missing WAR causes the packaging/archive stage to fail.
- Failed health check marks the deployment as failed and requires rollback to the last successful artifact.
