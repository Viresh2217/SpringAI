SpringAI

===

This repo is created for spring ai learning project


1) To create new API key(opensource)



Using Grok Api key(https://groq.com/)



create new API Key here and add in application property


2) Steps for RAG project


1) Install ollama locally. Two model required 1 for chat and 2 for embedding.
2) Download ollama 1.3GB, codellama 3.5GB, nomic-embed-text 245MB 
3) CMD--> ollama run codellama

4\) check ollama is running or not --> http://localhost:11434/ (default port)



5\) Install docker in local
6) use this to run mariaDb--> docker run -d --name mariadb1 -p 3308:3306 --env MARIADB\_ROOT\_PASSWORD=<password> mariadb:11.8

7\) Docker is running or not --> open GUI docker and check status

docker images 

docker list


8)before use below please check connecting from Dbeaver and delete mariaDb image from docker GUI

use this to run mariaDb--> docker run -d --name mariadb1 -p 3308:3306 --env MARIADB\_ROOT\_PASSWORD=password mariadb:11.8

9)Delete localhost from Dbeaver and run below after creating DB-springaidb

ALTER TABLE vector\_store MODIFY embedding VECTOR(768) NOT NULL;



10\) http://localhost:8080/ai/rag?q=what is java?

