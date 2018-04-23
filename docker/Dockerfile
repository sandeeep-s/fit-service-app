FROM jetty:9.4.9
MAINTAINER Sandeep Shinde

COPY ./resources/configuration.properties "$JETTY_BASE/resources/"
COPY ./resources/jetty/systemproperties.ini "$JETTY_BASE/start.d/"


RUN java -jar "$JETTY_HOME/start.jar" --create-startd --add-to-start=cdi --approve-all-licenses

COPY ./artifacts/fit-service.war /var/lib/jetty/webapps
