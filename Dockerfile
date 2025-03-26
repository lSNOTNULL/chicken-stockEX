FROM ubuntu:latest
LABEL authors="iream"

ENTRYPOINT ["top", "-b"]