#!/bin/bash

ln -s /opt/bitnami/keycloak/bin/kcadm.sh /usr/local/bin/kcadm

kcadm config credentials --server $KEYCLOAK_TARGET_SERVER --realm $KEYCLOAK_ADMIN_REALM --user $KEYCLOAK_ADMIN --password $KEYCLOAK_ADMIN_PASSWORD

# Create realm
kcadm create realms -s realm='application' -s enabled=true

# Create roles
kcadm create roles -r 'application' -s name='admin' -o
kcadm create roles -r 'application' -s name='support' -o

# Create groups
kcadm create groups -r 'application' -s name='admin'
kcadm create groups -r 'application' -s name='support'

# Create users
kcadm create users -r 'application' -s username='admin' -s email='admin@example.com' -s enabled=true -s emailVerified=true
kcadm set-password -r 'application' --username 'admin' --new-password 'Qwerty123'
kcadm create users -r 'application' -s username='support01' -s email='support01@example.com' -s enabled=true -s emailVerified=true
kcadm set-password -r 'application' --username 'support01' --new-password 'Qwerty123'
kcadm create users -r 'application' -s username='support02' -s email='support02@example.com' -s enabled=true -s emailVerified=true
kcadm set-password -r 'application' --username 'support02' --new-password 'Qwerty123'
kcadm create users -r 'application' -s username='user01' -s email='user01@example.com' -s enabled=true -s emailVerified=true
kcadm set-password -r 'application' --username 'user01' --new-password 'Qwerty123'
kcadm create users -r 'application' -s username='user02' -s email='user02@example.com' -s enabled=true -s emailVerified=true
kcadm set-password -r 'application' --username 'user02' --new-password 'Qwerty123'

# Create clients
kcadm create clients -r 'application'  -f - << EOF
  {
    "clientId": "api",
    "rootUrl": "",
    "adminUrl": "",
    "baseUrl": "",
    "surrogateAuthRequired": false,
    "enabled": true,
    "alwaysDisplayInConsole": true,
    "clientAuthenticatorType": "client-secret",
    "secret": "4Ggxc50xzu5j1qFk5rZ4OPHwvNFXLpNX",
    "redirectUris": ["*"],
    "webOrigins": ["*"],
    "bearerOnly": false,
    "consentRequired": false,
    "standardFlowEnabled": true,
    "implicitFlowEnabled": false,
    "directAccessGrantsEnabled": true,
    "serviceAccountsEnabled": true,
    "publicClient": false,
    "frontchannelLogout": true,
    "protocol": "openid-connect",
    "defaultClientScopes" : [ "web-origins", "acr", "roles", "profile", "email" ],
    "optionalClientScopes" : [ "address", "phone", "offline_access", "microprofile-jwt" ]
  }
EOF

# Grant roles
kcadm add-roles -r 'application' --gname 'admin' --rolename 'admin'
kcadm add-roles -r 'application' --gname 'admin' --rolename 'support'
kcadm add-roles -r 'application' --gname 'support' --rolename 'support'

# Add users to groups
function add_user_to_group {
  local member_user=$1
  local member_group=$2
  local member_user_id=$(kcadm get users -r 'application' -q exact=true -q username="$member_user" --fields 'id' --format csv | tr -d '"')
  local member_group_id=$(kcadm get group-by-path/$member_group -r 'application' --fields 'id' --format csv | tr -d '"')
  if [[ ! -z $member_group_id && ! -z $member_user_id ]]; then
    echo "Add user with id=$member_user_id ($member_user) to a group with id=$member_group_id ($member_group)"
    kcadm update -r 'application' users/$member_user_id/groups/$member_group_id
  fi
}
add_user_to_group 'admin' 'admin'
add_user_to_group 'support01' 'support'
add_user_to_group 'support02' 'support'
