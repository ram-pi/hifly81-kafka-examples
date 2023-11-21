#!/bin/bash

echo "Stopping docker containers..."
docker-compose -f kafka-connect-source-event-router/docker-compose.yml --env-file .env down --volumes
rm -Rf kafka-connect-source-event-router/postgres-data
