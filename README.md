# Build
mvn clean package && docker build -t at.faun.pos.dobl.test/studiRe .

# RUN

docker rm -f studiRe || true && docker run -d -p 8080:8080 -p 4848:4848 --name studiRe at.faun.pos.dobl.test/studiRe 