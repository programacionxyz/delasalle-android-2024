#!/bin/bash

# Variables
RESOURCE_GROUP="delasalle-vm"
VM_NAME="delasalle-vm-ubuntu"
LOCATION="eastus"
USERNAME="azureuser"

echo "Azure Login"
az login

echo "Creating Resources Group..."
az group create --name $RESOURCE_GROUP --location $LOCATION

# Crear la máquina virtual
echo "Creating the Virtual Machine"
az vm create \
  --resource-group $RESOURCE_GROUP \
  --name $VM_NAME \
  --image Ubuntu2204 \
  --admin-username $USERNAME \
  --generate-ssh-keys

echo "Openning port 22"
az vm open-port --port 22 --resource-group $RESOURCE_GROUP --name $VM_NAME

echo "Getting the public IP"
VM_IP=$(az vm show \
  --resource-group $RESOURCE_GROUP \
  --name $VM_NAME \
  --show-details \
  --query [publicIps] \
  --output tsv)

echo "PUBLIC IP Address $VM_IP"

echo "To connect to the virtual machine, use the following command:"
echo "ssh $USERNAME@$VM_IP"
