FROM node:alpine

RUN npm install -g @redocly/cli

WORKDIR /app

COPY openapi.yaml /app/openapi.yaml

RUN redocly build-docs /app/openapi.yaml --output /app/index.html

FROM nginx:alpine

COPY --from=0 /app/index.html /usr/share/nginx/html/index.html

EXPOSE 80