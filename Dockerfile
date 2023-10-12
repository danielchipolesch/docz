FROM ubuntu:latest
LABEL authors="danielchipolesch"

ENTRYPOINT ["top", "-b"]