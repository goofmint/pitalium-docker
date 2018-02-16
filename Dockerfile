FROM tomcat
MAINTAINER Atsushi Nakatsugawa <atsushi@moongift.jp>

ADD https://www.htmlhifive.com/ja/download/pitalium/pitalium_1.2.1.zip /tmp/
WORKDIR /tmp
RUN unzip pitalium_1.2.1.zip 
WORKDIR /tmp/pitalium_1.2.1/
RUN mkdir pitalium-explorer
RUN mv pitalium-explorer.war pitalium-explorer
WORKDIR /tmp/pitalium_1.2.1/pitalium-explorer/
RUN unzip pitalium-explorer.war
WORKDIR /tmp/pitalium_1.2.1/pitalium-explorer/WEB-INF/classes/
RUN sed -e 's/pitalium-results1/\/usr\/results/' explorerPersisterConfig.json.bak > explorerPersisterConfig.json
RUN mv /tmp/pitalium_1.2.1/pitalium-explorer /usr/local/tomcat/webapps/
