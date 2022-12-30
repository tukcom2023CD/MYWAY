FROM nginx:latest

COPY build/ /usr/share/nginx/html

RUN rm -rf /etc/nginx/conf.d/default.conf
COPY ./nginx.conf /etc/nginx/conf.d