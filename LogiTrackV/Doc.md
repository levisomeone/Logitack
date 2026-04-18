Documentação do Projeto de Sistema de Gestão Logístico

Modelo: Management host
Modelo de Datação: mm.dd.ano.hora:min.
Coverity Scan: Passing
JDK utilizado : .openjdk-25.0.2.intellij
Main IML version 1.0 encouraging UTF-8
https://github.com/levisomeone/Logitrack
Autor: Pedro Levi Pereira da Silva
Dev System: Pedro Levi Pereira da Silva

Sumário


1. Visão Geral
1.1 Propósito do Sistema
1.2 Escopo
1.3 Público-alvo
2. Objetivos
2.1 Objetivos Gerais
2.2 Requisitos Atendidos
2.3 Demandas Técnicas
3. Funcionalidades
3.1 Gerenciamento de Frota
3.2 Herança e Polimorfismo
3.3 Cálculo de Autonomia
3.4 Monitoramento Seletivo
3.5 Enumerações
3.6 Métodos de Gerenciamento
3.7 Reutilização de Código
3.8 Eficiência e Busca
3.9 Clareza e Encapsulamento
3.10 Extensibilidade
4. Lista de Funções
4.1 calcularAutonomia()
4.2 adicionarVeiculo()
4.3 buscarPorPlaca()
4.4 listarVeiculosDisponiveis()
4.5 gerarRelatorioAutonomia()
4.6 alterarStatusVeiculo()
4.7 enviarCoordenadas()
4.8 obterLocalizacaoAtual()
4.9 removerVeiculo()
4.10 getTamanhoFrota()
5. Estrutura do Projeto
5.1 Hierarquia de Pastas
5.2 StatusVeiculo.java (Enum)
5.3 TipoCombustivel.java (Enum)
5.4 Monitoravel.java (Interface)
5.5 Veiculo.java (Classe Abstrata)
5.6 Caminhao.java (Subclasse)
5.7 Van.java (Subclasse)
5.8 GerenciadorFrota.java (Serviço)
6. Explicações Técnicas
6.1 Explicação dos Booleanos
6.2 Explicação dos System.out.println
7. Garantia de Conformidade
7.1 Anatel e LGPD
7.2 Monitoramento com Responsabilidade
7.3 Dados Simulados
7.4 Assiduidade com as Regras
8. Log dos Processos
8.1 Cadastro de Veículos
8.2 Controle de Status
8.3 Listagem de Veículos Disponíveis
8.4 Relatório de Autonomia
8.5 Busca por Placa
8.6 Listagem Completa da Frota
8.7 Monitoramento Seletivo
8.8 Remoção de Veículos
8.9 Questão Teórica
9. Conformidade por Etapa
9.1 Resumo de Conformidade
9.2 Declaração de Conformidade
10. Referências
10.1 Links e Documentações
10.2 Repositório do Projeto



Visão Geral

O LogiTrack é um tipo modelo-sistema de gerenciamento logístico para aplicações diversas, este desenvolvido em Java para demonstrar os conceitos de Programação Orientada a Objetos (POO) e para a conclusão do desafio proposto.


Objetivos:
Aqui cabe explicação quanto a objetivos e requisitos do problema, que geram certas demandas como classe abstrata Veículo e uso de funções da classe interface, portanto os pontos abaixo são os objetivos gerais que foram alcançados por meio de pesquisas e relacionados.

Simplificar o gerenciamento de caminhões e vans em uma única estrutura de dados.
Separar responsabilidades entre pacotes modelo (entidades) e serviços. (gerenciamento).
Permitir comportamentos diferentes sem modificar a estrutura principal através de polimorfismo.
Maximizar a flexibilidade com interfaces que só são implementadas quando necessário.
Controle de Interface para acesso logístico a funções de busca e localização.
Cadastrar diferentes tipos de veículos (caminhões e vans) em uma única frota, garantindo que dados como placas e combustível estejam atrelados.
Gerar relatório de autonomia de cada veículo, possibilitando a regulamentação e registro de atividades futuras como possíveis implementações.
Simplificação no sistema de buscas, tipo de busca por placa em tempo constante O(1) usando HashMap, gerando efetividade sem necessidade de API’s complexas.
Código com estrutura clara e direta. A classe Veículo tem apenas o essencial e pode ser aproveitado futuramente para possíveis adições.


Funcionalidades

A gerência de funcionalidade deve ser ao mesmo tempo coesa com a atividade proposta e com margem para melhorias, as funcionalidades quando ao se referir ao projeto são:

Gerenciamento de frota com armazenamento em List e busca instantânea como por placa usando Map.
Herança e Polimorfismo com classe abstrata Veículo e subclasses Caminhao e Van
Cálculo de autonomia personalizado para cada tipo de veículo
Monitoramento seletivo através da interface Monitoravel (apenas caminhões)
Enumerações para StatusVeiculo e TipoCombustivel
Métodos de gerenciamento para adicionar, listar, buscar, alterar status e remover veículos
Reutilização: as funções aproveitam a estrutura de herança
Eficiência: busca por placa é instantânea, listagem é simples
Clareza: os nomes das funções dizem exatamente o que fazem
Encapsulamento: as funções manipulam os dados sem expor detalhes internos
Extensibilidade: novas funções podem ser adicionadas sem quebrar as existentes
Resumo
As funções do LogiTrack foram desenhadas para serem simples, eficientes e fáceis de entender. Cada uma tem uma responsabilidade clara e bem definida. O polimorfismo permite que funções como calcularAutonomia() se comportem de forma diferente sem complicar o código. O resultado é um sistema funcional que demonstra na prática os principais conceitos de POO em Java.



Lista de funções:
→ calcularAutonomia() → double → Valor da autonomia em km (ex: 36666.67)
→ adicionarVeiculo() → void → Mensagem "Veículo ABC-1234 adicionado a lista!"
→ buscarPorPlaca() → Veiculo → Objeto Veiculo encontrado ou null
→ listarVeiculosDisponiveis() → void → Lista de veículos com status DISPONIVEL
→ gerarRelatorioAutonomia() → void → Relatório com placa e autonomia de cada veículo
→ alterarStatusVeiculo() → void → Mensagem "Status do veículo DEF-5678 alterado para EM_MANUTENCAO"
→ enviarCoordenadas() → void → Mensagem "Coordenadas via Satélite R2 - Caminhão ABC-1234"
→ obterLocalizacaoAtual() → String → "Lt: -23.5505, Ln: -46.6333 - Caminhão ABC-1234"
→ removerVeiculo() → void → Mensagem "Veículo AAB-9012 removido da frota"
→ getTamanhoFrota() → int → Número total de veículos na frota (ex: 4)

Estrutura do Projeto - Modelo baseado em Hierarquia

src/
├── Main.java
└── br/
└── edu/
└── logistica/
├── modelo/
│ ├── StatusVeiculo.java (Enum)
│ ├── TipoCombustivel.java (Enum)
│ ├── Monitoravel.java (Interface)
│ ├── Veiculo.java (Classe Abstrata)
│ ├── Caminhao.java (Classe)
│ └── Van.java (Classe)
└── servico/
└── GerenciadorFrota.java (Classe)

StatusVeiculo.java (Enum)
Define os três estados possíveis de um veículo na frota: DISPONIVEL, EM_MANUTENCAO e EM_VIAGEM.
Tipo: Enum | Retorno: Nenhum (apenas define constantes)

TipoCombustivel.java (Enum)
Define os tipos de combustível com seus respectivos fatores de eficiência: DIESEL (5.5), GASOLINA (10.2) e ELETRICO (15.0). O fator representa quantos quilômetros o veículo faz por unidade de energia.
Tipo: Enum | Retorno: double (getFator() retorna 5.5, 10.2 ou 15.0)

Monitoravel.java (Interface)
Define o contrato para monitoramento com os métodos enviarCoordenadas() e obterLocalizacaoAtual(). Apenas caminhões implementam esta interface.
Tipo: Interface
enviarCoordenadas() → void → Mensagem no console
obterLocalizacaoAtual() → String → Texto com coordenadas

Veiculo.java (Classe Abstrata)
Classe base que contém os atributos comuns: placa, capacidadeCarga, status e tipoCombustivel. Possui três construtores com sobrecarga e o método abstrato calcularAutonomia() que obriga as subclasses a implementarem sua própria lógica.
Tipo: Classe Abstrata
calcularAutonomia() → double → Valor da autonomia em km
getPlaca() → String → Retorna a placa do veículo
getCapacidadeCarga() → double → Retorna a capacidade de carga
getStatus() → StatusVeiculo → Retorna o status atual
getTipoCombustivel() → TipoCombustivel → Retorna o tipo de combustível
setPlaca(String) → void → Define a placa
setCapacidadeCarga(double) → void → Define a capacidade
setStatus(StatusVeiculo) → void → Define o status
setTipoCombustivel(TipoCombustivel) → void → Define o combustível

Caminhao.java (Subclasse)
Herda de Veiculo e implementa Monitoravel. Possui o atributo adicional quantidadeEixos. O cálculo da autonomia é: (capacidadeCarga × fator do combustível) ÷ (quantidadeEixos × 0.75). Implementa os métodos de monitoramento enviarCoordenadas() e obterLocalizacaoAtual().
Tipo: Classe Concreta
calcularAutonomia() → double → Retorna (capacidadeCarga × fator) ÷ (quantidadeEixos × 0.75)
enviarCoordenadas() → void → System.out.println("Coordenadas via Satélite R2 - Caminhão" + placa)
obterLocalizacaoAtual() → String → Retorna "Lt: -23.5505, Ln: -46.6333 - Caminhão" + placa
getQuantidadeEixos() → int → Retorna o número de eixos
setQuantidadeEixos(int) → void → Define a quantidade de eixos

Van.java (Subclasse)
Herda apenas de Veiculo. Possui o atributo adicional possuiRefrigeracao (boolean). O cálculo da autonomia é: capacidadeCarga × fator do combustível. Se possuiRefrigeracao for true, a autonomia sofre um desconto de 20%.
Tipo: Classe Concreta
calcularAutonomia() → double → Retorna capacidadeCarga × fator (se refrigeracao = true, multiplica por 0.8)
isPossuiRefrigeracao() → boolean → Retorna true ou false
setPossuiRefrigeracao(boolean) → void → Define se possui refrigeração

GerenciadorFrota.java (Serviço)
Classe responsável por gerenciar a frota. Utiliza uma List (ArrayList) para armazenar os veículos e um Map (HashMap) para busca rápida por placa. Métodos implementados: adicionarVeiculo, listarVeiculosDisponiveis, gerarRelatorioAutonomia, buscarPorPlaca, listarTodosVeiculos, alterarStatusVeiculo, removerVeiculo e getTamanhoFrota.
Tipo: Classe de Serviço
adicionarVeiculo(Veiculo v) → void → System.out.println("Veículo " + v.getPlaca() + " adicionado a lista!")
listarVeiculosDisponiveis() → void → System.out.println com veículos com status DISPONIVEL
gerarRelatorioAutonomia() → void → System.out.printf com placa e autonomia de cada veículo
buscarPorPlaca(String placa) → Veiculo → Retorna objeto Veiculo ou null
listarTodosVeiculos() → void → System.out.println com todos os veículos da frota
alterarStatusVeiculo(String placa, StatusVeiculo novoStatus) → void → System.out.println de confirmação
removerVeiculo(String placa) → void → System.out.println de confirmação
getTamanhoFrota() → int → Retorna frota.size()

Explicação dos Booleanos
O boolean possuiRefrigeracao na classe Van controla se o veículo possui sistema de refrigeração. Quando é true, a autonomia da van é reduzida em 20% porque o sistema de refrigeração consome energia. Quando é false, a autonomia permanece integral.
Tipo: boolean | Retorno: true ou false (isPossuiRefrigeracao())

Explicação dos System.out.println
O sistema utiliza três tipos de saída: println para mensagens simples, println com concatenação (+) para juntar texto com variáveis, e printf para formatação de números decimais com duas casas.
Tipo: void | Retorno: Exibição no console
System.out.println("texto") → void → Exibe texto simples
System.out.println("texto" + variavel) → void → Exibe texto concatenado
System.out.printf("texto %s %.2f", string, double) → void → Exibe texto formatado





O que a Anatel e a LGPD têm a ver com o LogiTrack?
O LogiTrack foi desenvolvido pensando não apenas em código funcional, mas também em responsabilidade com os dados das pessoas.Então,  seguindo os princípios da Resolução Anatel nº 772/2025  https://informacoes.anatel.gov.br/legislacao/resolucoes/2025/2001-resolucao-772 e da Lei Geral de Proteção de Dados (LGPD), o sistema adota práticas que colocam o em primeiro lugar.
Monitoramento com responsabilidade
No LogiTrack, apenas os caminhões possuem rastreamento via satélite. Isso não foi uma escolha técnica aleatória. Foi uma decisão consciente: nem todo veículo precisa ser monitorado. Assim como na vida real, a gente só rastreia o que é necessário, não háexcessos. Isso está alinhado com o princípio da LGPD da necessidade e proporcionalidade https://capital.sp.gov.br/web/governo/w/lgpdpmsp  
Dados simulados:
Os dados de localização retornados pelo sistema são simulados. Mas a lógica por trás deles é real: qualquer sistema de rastreamento deve ser transparente, audível e controlado. O LogiTrack simula isso ao permitir que apenas veículos autorizados (caminhões) enviem coordenadas, e que o usuário saiba exatamente quando isso acontece.
O que isso significa para você?
Você sabe quem está sendo monitorado
Você sabe por que está sendo monitorado
Você vê o resultado do monitoramento de forma clara e simples
O sistema não esconde nada
Assiduidade com as regras.
Assiduidade significa estar presente, ser constante, não falhar com o compromisso. O LogiTrack foi construído para ser:
Transparente: mostra o que faz, quando faz e por que faz
Controlável: o status do veículo pode ser alterado a qualquer momento
Respeitoso: só monitora quem precisa ser monitorado
Claro: cada mensagem de localização é explícita e direta.








Log dos Processos:

=== SISTEMA LOGITRACK ===

Veículo ABC-1234 adicionado a lista!
Veículo DEF-5678 adicionado a lista!
Veículo GHI-9990 adicionado a lista!
Veículo AAB-9012 adicionado a lista!
Veículo BCC-3456 adicionado a lista!

--- ALTERANDO STATUS ---
Status do veículo DEF-5678 alterado para EM_MANUTENCAO
Status do veículo BCC-3456 alterado para EM_VIAGEM

===== VEÍCULOS DISPONÍVEIS =====
Placa: ABC-1234 / Tipo: Caminhao
Placa: GHI-9990 / Tipo: Caminhao
Placa: AAB-9012 / Tipo: Van

===== RELATÓRIO DE AUTONOMIA =====
Placa: ABC-1234 / Autonomia: 36666,67 km
Placa: DEF-5678 / Autonomia: 44000,00 km
Placa: GHI-9990 / Autonomia: 22366,67 km
Placa: AAB-9012 / Autonomia: 20400,00 km
Placa: BCC-3456 / Autonomia: 36000,00 km

=== BUSCA POR PLACA ===
Veículo encontrado: ABC-1234 - Caminhao

--- Buscando placa inexistente ---
Veiculo com placa ZZZ-9999 não encontrado.

=== TODOS OS VEÍCULOS DA FROTA ===
Placa: ABC-1234 | Tipo: Caminhao | Status: DISPONIVEL | Autonomia: 36666,67 km
Placa: DEF-5678 | Tipo: Caminhao | Status: EM_MANUTENCAO | Autonomia: 44000,00 km
Placa: GHI-9990 | Tipo: Caminhao | Status: DISPONIVEL | Autonomia: 22366,67 km
Placa: AAB-9012 | Tipo: Van | Status: DISPONIVEL | Autonomia: 20400,00 km
Placa: BCC-3456 | Tipo: Van | Status: EM_VIAGEM | Autonomia: 36000,00 km

=== DEMONSTRAÇÃO DO MONITORAVEL ===
Testando monitoramento do Caminhão ABC-1234:
Coordenadas via Satélite R2 - CaminhãoABC-1234
Localização atual: Lt: -23.5505, Ln: -46.6333 - CaminhãoABC-1234

Verificando se a Van AAB-9012 é monitorável:
Van é monitorável? false

=== TESTANDO REMOÇÃO ===
Veículo AAB-9012 removido da frota.
Total de veículos após remoção: 4

=== QUESTÃO TEÓRICA ===
P: Por que usamos uma Interface para o monitoramento e uma Classe Abstrata para o veículo?
R: Porque nem todo veículo é monitorável. A interface permite que apenas os
   caminhões (que possuem rastreador) implementem o monitoramento, enquanto
   as vans não precisam ter esses métodos. A classe abstrata Veiculo define
   o que é comum a todos os veículos (placa, capacidade, combustível, etc).

=== SISTEMA LOGITRACK ENCERRADO ===

1. Cadastro de Veículos
Log gerado:

Veículo ABC-1234 adicionado a lista!
Veículo DEF-5678 adicionado a lista!
Veículo GHI-9990 adicionado a lista!
Veículo AAB-9012 adicionado a lista!
Veículo BCC-3456 adicionado a lista!

Conformidade: Todo veículo cadastrado possui identificação única (placa), garantindo rastreabilidade e controle individual. O sistema registra cada inclusão, mantendo auditoria clara de quais veículos compõem a frota.

2. Controle de Status
Log gerado:

Status do veículo DEF-5678 alterado para EM_MANUTENCAO
Status do veículo BCC-3456 alterado para EM_VIAGEM

Conformidade: O sistema permite alteração de status dos veículos, refletindo situações reais de manutenção e viagem. Isso atende ao princípio da transparência, onde o operador sabe exatamente a situação de cada veículo.

3. Listagem de Veículos Disponíveis
Log gerado:

Placa: ABC-1234 / Tipo: Caminhao
Placa: GHI-9990 / Tipo: Caminhao
Placa: AAB-9012 / Tipo: Van
Conformidade: Apenas veículos com status DISPONIVEL são exibidos. Isso evita alocação de veículos em manutenção ou em viagem, prevenindo erros operacionais e garantindo segurança.

4. Relatório de Autonomia
Log gerado:

Placa: ABC-1234 / Autonomia: 36666,67 km
Placa: DEF-5678 / Autonomia: 44000,00 km
Placa: GHI-9990 / Autonomia: 22366,67 km
Placa: AAB-9012 / Autonomia: 20400,00 km
Placa: BCC-3456 / Autonomia: 36000,00 km
Conformidade: O relatório de autonomia demonstra transparência nos dados operacionais de cada veículo. O gestor tem acesso claro à performance esperada de cada recurso da frota.

5. Busca por Placa
Log gerado:

Veículo encontrado: ABC-1234 - Caminhao
Veiculo com placa ZZZ-9999 não encontrado.

Conformidade: A busca por placa é instantânea e retorna informação precisa quando o veículo existe ou mensagem clara quando não existe. Isso atende ao princípio da transparência e exatidão das informações.

6. Listagem Completa da Frota
Log gerado:

Placa: ABC-1234 | Tipo: Caminhao | Status: DISPONIVEL | Autonomia: 36666,67 km
Placa: DEF-5678 | Tipo: Caminhao | Status: EM_MANUTENCAO | Autonomia: 44000,00 km
Placa: GHI-9990 | Tipo: Caminhao | Status: DISPONIVEL | Autonomia: 22366,67 km
Placa: AAB-9012 | Tipo: Van | Status: DISPONIVEL | Autonomia: 20400,00 km
Placa: BCC-3456 | Tipo: Van | Status: EM_VIAGEM | Autonomia: 36000,00 km

Conformidade: A listagem completa exibe todos os veículos com suas respectivas informações. O princípio da transparência é plenamente atendido, pois o gestor tem visão total da frota.

7. Monitoramento Seletivo (Monitoravel)
Log gerado:

Testando monitoramento do Caminhão ABC-1234:
Coordenadas via Satélite R2 - CaminhãoABC-1234
Localização atual: Lt: -23.5505, Ln: -46.6333 - CaminhãoABC-1234

Verificando se a Van AAB-9012 é monitorável:
Van é monitorável? false
Conformidade com Anatel e LGPD:
Princípio
Aplicação no LogiTrack
Necessidade
Apenas caminhões possuem rastreador. Vans não são monitoradas porque não há necessidade operacional.
Proporcionalidade
O monitoramento é restrito ao necessário para a operação logística, sem excessos.
Transparência
O sistema informa claramente quando um veículo está sendo monitorado e quando não está.
Finalidade
O rastreamento tem finalidade específica (controle de frota), não sendo utilizado para outros fins.

A Resolução Anatel nº 772/2025 estabelece regras para rastreamento veicular, incluindo a obrigatoriedade de transparência e consentimento. O LogiTrack respeita essas diretrizes ao:
Informar explicitamente quando um veículo envia coordenadas
Permitir que apenas veículos autorizados (caminhões) sejam rastreados
Simular o envio de dados de forma ética e controlada

8. Remoção de Veículos
Log gerado:

Veículo AAB-9012 removido da frota.

Total de veículos após remoção: 4
Conformidade: A remoção de veículos é registrada e o sistema atualiza imediatamente o total da frota. Isso garante que dados desatualizados não permaneçam no sistema, atendendo ao princípio da exatidão e à Política de Retenção de Dados da LGPD.

9. Questão Teórica - Justificativa Arquitetural
Log gerado:
text
P: Por que usamos uma Interface para o monitoramento e uma Classe Abstrata para o veículo?
R: Porque nem todo veículo é monitorável. A interface permite que apenas os
   caminhões (que possuem rastreador) implementem o monitoramento, enquanto
   as vans não precisam ter esses métodos. A classe abstrata Veiculo define
   o que é comum a todos os veículos (placa, capacidade, combustível, etc).
Conformidade: Esta decisão arquitetural está alinhada com a LGPD ao garantir que apenas veículos que realmente necessitam de monitoramento o possuam. A separação entre classe abstrata (características comuns) e interface (comportamento opcional) evita a coleta desnecessária de dados.

Resumo de Conformidade
Requisito
Status
Evidência
Transparência no monitoramento
Atendido
Mensagens claras de envio de coordenadas
Monitoramento apenas quando necessário
 Atendido
Apenas caminhões implementam Monitoravel
Controle de status dos veículos
 Atendido
Status DISPONIVEL, EM_MANUTENCAO, EM_VIAGEM
Registro de operações
 Atendido
Logs detalhados de todas as ações
Busca precisa por identificador
 Atendido
Busca por placa com retorno claro
Remoção e retenção de dados
 Atendido
Remoção imediata com atualização do sistema


Declaração de Conformidade
O sistema LogiTrack atende plenamente aos princípios estabelecidos pela Resolução Anatel nº 772/2025 e pela LGPD, especialmente nos aspectos de:
Necessidade: coleta e monitoramento apenas do essencial
Proporcionalidade: restrição do rastreamento a veículos que realmente precisam
Transparência: comunicação clara de todas as ações de monitoramento
Exatidão: dados precisos e atualizados sobre a frota
Segurança: controle de status e permissões


Todos os termos relacionados a esta documentação estão centrados no projeto https://github.com/levisomeone/Logitrack 

