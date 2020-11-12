#!/bin/bash

printf "\033c"
printf "Enter service to DEPLOY:\n"
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
	cd backends/marketplace
    ./mvnw clean package
    docker build -t laurel-marketplace .
    docker tag laurel-marketplace morozco/laurel-marketplace
    docker push morozco/laurel-marketplace
    cd ../../kube
    kubectl delete -f marketplace.yaml
    kubectl apply -f marketplace.yaml
    ;;

  "2")
    cd backends/notifications
    ./mvnw clean package
    docker build -t laurel-notifications .
    docker tag laurel-notifications morozco/laurel-notifications
    docker push morozco/laurel-notifications
    cd ../../kube
    kubectl delete -f notifications.yaml
    kubectl apply -f notifications.yaml
    ;;

  "3")
    cd backends/payments
    ./mvnw clean package
    docker build -t laurel-payments .
    docker tag laurel-payments morozco/laurel-payments
    docker push morozco/laurel-payments
    cd ../../kube
    kubectl delete -f payments.yaml
    kubectl apply -f payments.yaml
    ;;

  "4")
    cd backends/scoring
    ./mvnw clean package
    docker build -t laurel-scoring .
    docker tag laurel-scoring morozco/laurel-scoring
    docker push morozco/laurel-scoring
    cd ../../kube
    kubectl delete -f scoring.yaml
    kubectl apply -f scoring.yaml
    ;;

  "5")
    cd backends/shipping
    ./mvnw clean package
    docker build -t laurel-shipping .
    docker tag laurel-shipping morozco/laurel-shipping
    docker push morozco/laurel-shipping
    cd ../../kube
    kubectl delete -f shipping.yaml
    kubectl apply -f shipping.yaml
    ;;

  "6")
    cd backends/shopping-cart
    ./mvnw clean package
    docker build -t laurel-shopping-cart .
    docker tag laurel-shopping-cart morozco/laurel-shopping-cart
    docker push morozco/laurel-shopping-cart
    cd ../../kube
    kubectl delete -f shopping-cart.yaml
    kubectl apply -f shopping-cart.yaml
    ;;

  "7")
    cd backends/users
    ./mvnw clean package
    docker build -t laurel-users .
    docker tag laurel-users morozco/laurel-users
    docker push morozco/laurel-users
    cd ../../kube
    kubectl delete -f users.yaml
    kubectl apply -f users.yaml
    ;;
  *)
    echo -n "ERROR:: invalid service name."
    ;;
esac