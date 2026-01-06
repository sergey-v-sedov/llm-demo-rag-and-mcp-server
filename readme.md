Setup:
docker run -d --name pgvector -e POSTGRES_USER=app -e POSTGRES_PASSWORD=password -e POSTGRES_DB=demo -p 5432:5432 pgvector/pgvector:pg18-trixie
docker run -d -v ollama:/root/.ollama -p 11434:11434 --name ollama ollama/ollama
docker exec -it ollama ollama pull mxbai-embed-large
docker exec -it ollama ollama pull llama3.1

Run RAG indexing:
curl http://localhost:8080/index