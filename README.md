# teste-dock-backend
Teste para Software Engineer III - Dock

# Api RESTFull para Controle e Gerencia de Terminais
A Api permite consultas, inserções e modificações, mas não permite deleções (Vide item 2.d)
Foi escolhido Java como linguagem de programação por ser uma linguagem amplamente adotada e compilável, o que confere maior desempenho. Como é uma linguagem que força orientação a objetos, isot exige a criação de soluções estruturadas permitindo melhor leitura do código fonte.

# Testando
A api está disponibillizada no endereço público no Heroku:
```
http://dockapi-backend-teste.herokuapp.com
```
> **_Nota:_**  Buscando o endereço http://dockapi-backend-teste.herokuapp.com/dockApi/v1 você verá uma página de teste "Olá pessoas". Útil para testar se a aplicação está on-line.

Existem 2 entidades populadas na base de dados com logic = 111 e logic = 222.
A URL prexixo da aplicação é _http://dockapi-backend-teste.herokuapp.com/dockApi_

 - [versão da aplicação] =  v1
 - [nome da entidade] = terminal 
 - [atributo 'logic'] = Identificador princial da entidade terminal

# Consultas
Para fazer consultas, bastas seguir o padrão RESTfull. Exemplos:
 - Consultar todas as entidades terminal
```
GET http://dockapi-backend-teste.herokuapp.com/dockApi/v1/terminal
```

- Consultar entidades de terminal específica pela identidade (atributo logic) de valor = 111
 ```
GET http://dockapi-backend-teste.herokuapp.com/dockApi/v1/terminal/111
```

# Casdastro
Para fazer o cadastro, conforme requisitos: deve-se utilizar o verbo POST e enviar os valores da entidade do terminal em CSV.
Deve-se utilizar o VERBO POST e o Content-Type no cabeçalho deve ser 'text/html'. Exemplo:
```
POST http://dockapi-backend-teste.herokuapp.com/dockApi/v1/terminal
BODY: 4332211;123;PWWIN;0;F04A2E4088B;4;8.00b3;0;16777216;PWWIN
```

# Modificação
Para fazer a modificação, basta enviar VERBO PUT com a entidade no formato JSON. Exemplo: Atualizando a entidade terminal de logic = 777.

```
PUT http://dockapi-backend-teste.herokuapp.com/dockApi/v1/terminal/777
BODY: {
  "logic": 777,
  "serial": "55555-055",
  "model": "MPT-0555",
  "sam": 0,
  "ptid": "ptid-555",
  "plat": 4,
  "version": "v1",
  "mxr": 0,
  "mxf": 16777216,
  "pverfm": "PWWIN2"
}
```
