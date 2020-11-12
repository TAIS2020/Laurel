#!/bin/bash

printf "\033c"
printf "Enter service for UNDEPLOY:\n"
printf "[1] marketplace\n"
printf "[2] notifications\n"
printf "[3] payments\n"
printf "[4] scoring\n"
printf "[5] shipping\n"
printf "[6] shopping-cart\n"
printf "[7] users\n"
read SERVICE_NAME

case $SERVICE_NAME in

  "1")
    cd kube
	kubectl delete -f marketplace.yaml
    ;;

  "2")
    cd kube
    kubectl delete -f notifications.yaml
    ;;

  "3")
    cd kube
    kubectl delete -f payments.yaml
    ;;

  "4")
    cd kube
    kubectl delete -f scoring.yaml
    ;;

  "5")
    cd kube
    kubectl delete -f shipping.yaml
    ;;

  "6")
    cd kube
    kubectl delete -f shopping-cart.yaml
    ;;

  "7")
    cd kube
    kubectl delete -f users.yaml
    ;;
  *)
    echo -n "ERROR:: invalid service name."
    ;;
esac