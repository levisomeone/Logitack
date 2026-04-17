<p align="center">
  <pre>
    🔴 🟩 🟩
    🟩 🟩 
    🟩 🟩 🟩
    🟩 🟩
    ╔════════════════════════════════════════════════╗
    ║  I N S T I T U T O   F E D E R A L  ACOPIARA   ║
    ╚════════════════════════════════════════════════╝
  </pre>

  <table>
  <tr>
    <td><img src="https://img.shields.io/badge/Java-24%2B-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"></td>
    <td><img src="https://img.shields.io/badge/Packages-Maven%20%7C%20JAR-blue?style=for-the-badge&logo=apachemaven&logoColor=white"></td>
    <td><img src="https://img.shields.io/badge/System-Windows-0078D6?style=for-the-badge&logo=windows&logoColor=white"></td>
  </tr>
  <tr>
    <td><img src="https://img.shields.io/badge/Pull%20Requests-0-blue?style=for-the-badge&logo=github&logoColor=white"></td>
    <td><img src="https://img.shields.io/badge/Coverity%20Scan-Passing-brightgreen?style=for-the-badge"></td>
  </tr>
</table>

# LogiTrack - Sistema de Gerenciamento de Frota

LogiTrack é um sistema desenvolvido em Java para gerenciar diferentes tipos de veículos em uma frota logística, com os seguintes objetivos:

- Simplificar o gerenciamento de caminhões e vans em uma única estrutura de dados
- Separar responsabilidades entre pacotes modelo (entidades) e servico (gerenciamento)
- Permitir comportamentos diferentes sem modificar a estrutura principal através de polimorfismo
- Maximizar a flexibilidade com interfaces que só são implementadas quando necessário (apenas caminhões são monitoráveis)

## Features

- **Gerenciamento de frota** com armazenamento em List e busca instantânea por placa usando Map
- **Herança e Polimorfismo** com classe abstrata Veiculo e subclasses Caminhao e Van
- **Cálculo de autonomia personalizado** para cada tipo de veículo (caminhão considera eixos, van considera refrigeração)
- **Monitoramento seletivo** através da interface Monitoravel (apenas caminhões implementam)
- **Enumerações** para StatusVeiculo (DISPONIVEL, EM_MANUTENCAO, EM_VIAGEM) e TipoCombustivel (DIESEL, GASOLINA, ELETRICO)
- **Métodos de gerenciamento** para adicionar, listar, buscar, alterar status e remover veículos
- **Relatório de autonomia** demonstrando polimorfismo em ação
- **Filtragem de veículos disponíveis** por status
- **Busca por placa** em tempo constante O(1) utilizando HashMap
- **Compatível com os princípios SOLID** e boas práticas de POO

## Como executar o LogiTrack

### Executar no IntelliJ IDEA

1. Abra o IntelliJ IDEA
2. File → Open → Selecione a pasta do projeto
3. Aguarde o carregamento do projeto
4. Navegue até a classe `Main.java` em `src/`
5. Clique com botão direito em `Main.java`
6. Selecione **Run 'Main.main()'**
7. Ou pressione `Ctrl + Shift + F10` com o arquivo aberto

### Executar por linha de comando

  ```bash
  # Navegue até a pasta src
  cd src
  
  # Compilar todos os arquivos Java
  javac br/edu/logistica/modelo/*.java br/edu/logistica/servico/*.java Main.java
  
  # Executar o programa
  java Main

📁 src/
│
├── 🟦 Main.java
│
└── 📁 br/
    │
    └── 📁 edu/
        │
        └── 📁 logistica/
            │
            ├── 📁 modelo/
            │   │
            │   ├── 🟣 StatusVeiculo.java
            │   ├── 🟣 TipoCombustivel.java
            │   ├── 🟢 Monitoravel.java
            │   ├── 🔵 Veiculo.java
            │   ├── 🔵 Caminhao.java
            │   └── 🔵 Van.java
            │
            └── 📁 servico/
                │
                └── 🔵 GerenciadorFrota.java
