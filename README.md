# Kotlin

#21/06/2018
### Participantes:
- ailtonb
- fmoreno
- jpimentel
- lcamacho

## Positivos:
- Lanchinho
- Sem dispersões
- Aula de arquitetura

## Negativos:
- Amanda não veio
- Começamos só 17h30min

#17/05/2018
### Participantes:
- amandak
- ailtonb
- fmoreno
- jpimentel

## Planejamento:
- Botão Jogar quando todas as peças estiverem ok
- Gerar o tabuleiro do jogo ok
- Gerar tabuleiro advs. ok
- Desenhar tela do jogo

## Positivos:
- Lanchinho
- Pouco tempo de atraso
- Finalizamos uma etapa \o/

## Negativos:
- A Amanda não libera o pc
- Teve conversa paralela


## Próximos passos:
- Desenhar tela do jogo
- Alterar a regra relacionada a remover o navio.



## 10/05/2018
### Participantes:
- amandak
- ailtonb
- fmoreno
- jpimentel

## Planejamento:
- Especializar os métodos de click - onEmptyClick, onFilledClick - done
- Criar dialog para remover o navio - done (pendente botão cancelar)
- Count de navios restantes - done

## Positivos:
- Lanchinho
- Pouco tempo de atraso
- Finalizamos uma etapa \o/

## Negativos:
- Mad não espera o dojo acabar
- Mad não libera o pc quando acaba o tempo
- Teve conversa paralela

## Próximos passos:
- Criar o botão de jogar
- Activity de Jogo
- Marcar posições acertadas

## 03/05/2018
### Participantes:
- amandak
- ailtonb
- fmoreno

### Positivos:
- O Jean não participou
- Sem dispersões
- Sem conversas paralelas
- Lanchinho
- Máquina boa
- Não precisamos de adaptador hdmi
- Mesmo sem o Jean, Itabirito e André, conseguimos andar com algo.

### Negativos:
- Como o Jean não participou, tivemos dúvidas referentes a arquitetura e delegação das classes.
- Atraso por setup de nova máquina

### Próximos passos:
- Compilar o projeto!
- Remover a peça: a lógica foi iniciada mas é necessário realizar as chamadas nas camadas.
- Alterar o método de check ou criar um novo para retornar o navio.
- Criar a view que confirma a remoção do Navio
- Alterar o onclickItem para verificar se o navio existe, 
e realizar a lógica para mostrar a adição ou remoção do navio

- Mostrar indicador de quantidade de navios (restantes/total)
- Botão de Start no jogo se tudo tiver posicionado
- Vamos deixar desfazer/remover alguma peça? Desfazer a ultima parece bom
- Ou limpar o tabuleiro e reposicionar


## 26/04/2018
### Participantes:
- amandak
- ailtonb
- fmoreno
- jpimentel

### Positivos:
- André não participará mais
- Sem dispersões
- Sem conversas paralelas
- Lanchinho
- Máquina boa
- Adaptador HDMI

### Negativos:
- Como não fizemos a ata anterior, gastamos tempo pra começar
-

### Próximos passos:
- Mostrar indicador de quantidade de navios (restantes/total)
- Botão de Start no jogo se tudo tiver posicionado
- Vamos deixar desfazer/remover alguma peça? Desfazer a ultima parece bom
- Ou limpar o tabuleiro e reposicionar


## 08/02/2018
### Participantes:
  - amandak
  - andrech
  - fmoreno
  - jpimentel

### Solução planejada para o app Android
    - Início da estrutura para app Android
        - Firebase
             /Jogo
                 /id_jogo 
                    /tabuleiros
                     /jogadas
        - Layout
            Recycler view para montar o tabuleiro
            Cada tabuleiro será uma lista, navios e jogadas.
                DiffUtils
                Célula pode estar em 3 status - para quem está fazendo a jogada
                    Padrão - não foi jogado
                    Água - jogou e errou
                    Bomba - Jogou e acertou
                Célula pode estar em doi status - para quem está esperando a jogada do oponente
                    Padrão - vazio (água)
                    Ocupado - onde foi colocado o navio
                Para preencher o tabuleiro
                    Botão com a orientação - horizontal e vertical
                    Selecionar o tipoNavio de navio
                    Indicar a célula inicial e o jogo "desenha" o navio com as posições, seguindo a orientação
                    
        - Vir com a estrutura do projeto pronto.

### Pontos positivos:
  - Planejamento de como será feito o projeto em Android conforme documentado acima
  - Explicação de conceitos importantes para mobile (views)

### Pontos negativos:
  - Falta do espelhamento da TV;
  - Tempo reduzido devido a falta do ambiente configurado;

### Próximos passos:
  - Garantir que o ambiente (IDE, TV, etc) esteja configurado antes do início do Dojo;
  - Finalizar o desafio da batalha naval no Android;
  - Montar ambiente de backup
  - Definir uma tela a ser montada - desenhar tabuleiro das jogadas (já mostrando os enums)
  - Ler sobre recycler view
  - Verificar as imagens a serem utilizadas

---
## 02/02/2018

### Participantes:
  - ailtonb
  - amandak
  - andrech
  - fmoreno
  - jpimentel
  - lcamacho
  - marcosvc

### Pontos positivos:
  - Familiarização com a linguagem;
  - Levantamento do que deve ser feito separado em tarefas (ToDo/Done);

### Pontos negativos:
  - Não foi produtivo em relação ao ultimo
  - Falta do espelhamento da TV;
  - Tempo reduzido devido a falta do ambiente configurado;

### Próximos passos:
  - Garantir que o ambiente (IDE, TV, etc) esteja configurado antes do início do Dojo;
  - Finalizar o desafio da batalha naval no Android;


## 25/1/2018

### Participantes: 
  - ailtonb
  - amandak
  - andrech
  - fmoreno
  - lcamacho

### Pontos positivos:
  - Muito mais produtivo devido a quantidade de participantes;
  - Levantamento do que deve ser feito separado em tarefas (ToDo/Done);
  - Familiarização com a linguagem;

### Pontos negativos:
  - Falta do espelhamento da TV;
  - Tempo reduzido devido a falta do ambiente configurado;

### Próximos passos:
  - Garantir que o ambiente (IDE, TV, etc) esteja configurado antes do início do Dojo;
  - Finalizar o desafio da batalha naval;
 
## 18/1/2018

### Desafios:
  - Batalha Naval
  
### Participantes: 
  - amandak
  - andrech
  - fmoreno
  - jpimentel
  - lcamacho
  - marcosvc
  - patricio

### Pontos positivos:
  - Definiçao do projeto foi melhor que o anterior.
  - Do fato da equipe ser menor, a equipe teve uma sinergia melhor.
  - Aprendemos novas estruturas
  
### Pontos negativos:
  - Nao seguimos a risca o TDD.
  - Definicao do timebox da solucao foi de 50 minutos.
  - Atencao ao termino do rodizio do Dojo
  
### Próximos passos:
  - Concluir a soluçao
  - Mais Foco
  - Gerenciar o tempo do Dojo

---
## 11/1/2018

### Desafios:
  - Jogo da velha
  
### Participantes: 
  - amandak
  - andrech
  - ailtonb
  - csoares
  - enir
  - fmoreno
  - guilhermel
  - jpimentel
  - lcamacho
  - marcosvc

### Pontos positivos:
  - Dois novos participante
  - Trabalhamos um pouco mais a estrutura da linguagem
  - o trabalho com o piloto e copiloto houve melhoras
  
### Pontos negativos:
  - Desafio não foi concluido
  - Fizemos a solução, porém não foi aplicada completamente porque os participantes não entederam a solução comum todo
  - Faltou definir o escopo de cada classe
  - A definição da solução não foi completa(ainda perdemos tempo durante a codificação)

### Próximos passos:
  - Explorar mais as estruturas de dados e as caracteristicas da linguagem
  - dividir turma
---
## 4/1/2018

### Desafios:
  - http://
  
### Participantes: 
  - amandak
  - csoares
  - jpimentel
  - lcamacho
  - marcosvc
  - vilmarbf

### Pontos positivos:
  - Três novos participantes 
  - Piloto e copiloto foram mais participativos
  - 7 minutos parece funcionar bem
  - Foi decidio algoritmo antes do timer
  
### Pontos negativos:
  - Conversas paralelas(devido só piloto e copoloto falarem)
  - Participantes faltaram
  - A definição da solução não foi completa(ainda perdemos tempo durante a codificação)

### Próximos passos:
  - Arrumar problemas para que possa explorar a linguagem
  - Explorar mais as estruturas de dados e as caracteristicas da linguagem
--- 

## 14/12/2017

### Desafios:
  - http://dojopuzzles.com/problemas/exibe/caixa-eletronico/
  
### Participantes: 
  - andrech
  - csoares
  - eferraz
  - guilhermel 
  - jpimentel
  - marcosvc
  - patricio

### Pontos positivos:
  - Desafio parecia simples, mas foi interessante
  - Dois novos participantes 
  
### Pontos negativos:
  - Esquecimento do timer
  - Tempo de 5min é pouco tempo
  
### Próximos passos:
  - Enquanto estiver propondo solução não contabilizar o tempo
  - Não induzir o piloto
  - Melhorar atuação do co-piloto
  
--- 

## 07/12/2017

### Desafios:
  - http://dojopuzzles.com/problemas/exibe/lampadas-no-corredor/
  - http://br.spoj.com/problems/ENCOTEL/
  
### Participantes: 
  - andersonr
  - andrech
  - csoares
  - daianefs
  - guilhermel 
  - jpimentel
  - patricio

### Pontos positivos:
  - Lanche
  - Participação dos envolvidos 
  - Desafios interessantes
  - Interação entre os participantes
  - 1h 30m tempo suficiente 
  
### Pontos negativos:
  - Desconhecimento da linguagem
  
### Próximos passos:
  - Capacitação dos participantes iniciais para que possamos expandir
  - Definir frequência 
