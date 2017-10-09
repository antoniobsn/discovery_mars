# discovery_mars

## Objetivo

Explorar o planeta Marte utilizando sondas espaciais

## Como funciona?

Um conjunto de sondas é enviado pela NASA à Marte e irá pousar num planalto. 
Logo após as sondas terem pousado em Marte, é possivel movimenta-las através de requisições via API.


## Documentação da API

## Movimentar sondas em um planalto.
Movimentar todas as sondas em um planalto,
```
POST /api/v1/sonda/explorar
```
Exemplo
```
curl -X POST \
  /api/v1/sonda/explorar \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: b39e0a5b-d0db-c4a9-75dd-693ecae242cf' \
  -d '{
  "planalto": {
    "coordenadas": {
      "x": 5,
      "y": 5
    },
    "sondas": [
      {
        "comandos": ["L","M","L","M","L","M","L","M","M"],
        "direcao": "N",
        "posicao": {
          "x": 1,
          "y": 2
        }
      },
      {
        "comandos": ["M","M","R","M","M","R","M","R","R","M"],
        "direcao": "E",
        "posicao": {
          "x": 3,
          "y": 3
        }
      }
    ]
  }
}'
```

### Requisitos
- Java 8
- maven
