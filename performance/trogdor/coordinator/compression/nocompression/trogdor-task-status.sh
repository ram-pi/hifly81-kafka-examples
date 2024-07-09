#!/usr/bin/env bash


start=0
end=3
increment=1

current=$start

while(( $(echo "$current < $end" | /usr/bin/bc -l) )); do
  /kafka_2.13-3.7.1/bin/trogdor.sh client showTask -t localhost:8889 -i node-$current --show-status
  current=$(echo "$current + $increment" | /usr/bin/bc -l)
done