FROM node:18

WORKDIR /usr/src/app

COPY package*.json ./
COPY src ./src
COPY start.sh ./

RUN ["npm", "install"]

EXPOSE 8080

ENTRYPOINT [ "npm", "start" ]
