FROM airhacks/glassfish
COPY ./target/studiRe.war ${DEPLOYMENT_DIR}
