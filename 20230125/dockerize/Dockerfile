FROM node:18-alpine

WORKDIR /usr/app

COPY ./package*.json ./

RUN npm install 

COPY ./src ./src

EXPOSE 3000

ENTRYPOINT npm start
