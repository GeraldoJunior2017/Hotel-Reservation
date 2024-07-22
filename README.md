# Hotel Reservation System

## Descrição

Este é um sistema de reserva de hotéis que permite aos usuários pesquisar, comparar e reservar hotéis. O sistema também fornece um sistema de notificações para confirmar o processamento de check-in/check-out.

## Funcionalidades

1. **Pesquisa de Hotéis**: Os usuários podem pesquisar hotéis com base em critérios como destino, datas de check-in e check-out, número de quartos e número de hóspedes.
2. **Comparação de Opções**: Os usuários podem comparar diferentes opções de hotéis com base em preço, localização, comodidades e avaliações de outros usuários.
3. **Reserva de Quartos**: Os usuários podem selecionar um hotel e reservar quartos para as datas desejadas, inserindo informações como nome, contato e detalhes do pagamento.
4. **Sistema de Notificações**: O sistema envia notificações para confirmar o processamento de check-in/check-out com o devido status de confirmação da reserva.

## Endpoints da API

### Pesquisa de Hotéis

- **Endpoint**: `/hoteis/pesquisar`
- **Método**: `GET`
- **Parâmetros**:
  - `destino` (opcional)
  - `numQuartos` (opcional)
  - `numHospedes` (opcional)
  - `minAvaliacao` (opcional)
  - `dataCheckIn` (opcional)
  - `dataCheckOut` (opcional)

### Comparação de Hotéis

- **Endpoint**: `/hoteis/comparar`
- **Método**: `GET`
- **Parâmetros**:
  - `minPreco` (opcional)
  - `maxPreco` (opcional)
  - `localizacao` (opcional)
  - `comodidades` (opcional)
  - `minAvaliacao` (opcional)

### Criação de Reserva

- **Endpoint**: `/reservas/criar`
- **Método**: `POST`
- **Corpo**: JSON com detalhes da reserva

### Check-In

- **Endpoint**: `/reservas/checkin/{id}`
- **Método**: `POST`
- **Parâmetros**:
  - `id` (ID da reserva)

### Check-Out

- **Endpoint**: `/reservas/checkout/{id}`
- **Método**: `POST`
- **Parâmetros**:
  - `id` (ID da reserva)

### Notificações

- **Endpoint**: `/notificacoes`
- **Método**: `POST`
- **Corpo**: JSON com detalhes da notificação

## Instruções de Execução

1. **Construa o projeto**:
    bash
   ./mvnw clean package

Execute o JAR:
java -jar target/Hotel-Reservation-0.0.1-SNAPSHOT.jar


## Documentação da API

A documentação da API gerada pelo Swagger pode ser acessada em:

- **Swagger UI**: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

