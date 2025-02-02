package HashTable;

public class HashTentativaLinear<Key, Value> { 
    private int N; // Número de pares de chave/valor na tabela
    private int M = 512; // Tamanho da tabela hash
    private Key[] keys; // Chaves
    private Value[] vals; // Valores

    private int comparacoes;

    public HashTentativaLinear() {
        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];
    }

    public HashTentativaLinear(int cap) {
        keys = (Key[]) new Object[cap];
        vals = (Value[]) new Object[cap];
        M = cap;
    }

	private int hashMeu(Key chave) {
		int hash = 0;
		String chaveString = chave.toString();
		for (int i = 0; i < chaveString.length(); i++) {
			hash = (53 * hash + chaveString.charAt(i)) % M;
		}
		return hash;
	}

    /**
     * Função hash utilizando tentativa linear.
     * @param key
     * @param j Número de tentativas
     * @return Índice da chave
     */
    private int hashLinear(Key key, int j) { 
		int hash = hashMeu(key);
        return (hash + j) % M;
    }

    /**
     * Redimensiona a tabela de acordo com a quantidade de chaves.
     * @param cap Tamanho novo da tabela
     */
    private void resize(int cap) {
        HashTentativaLinear<Key, Value> t = new HashTentativaLinear<>(cap);
        for (int i = 0; i < keys.length; i++) {
			comparacoes++;
            if (keys[i] != null) {
                t.put(keys[i], vals[i]);
            }
        }
        keys = t.keys;
        vals = t.vals;
        M = t.M;
    }

    /**
     * Verifica se a chave está na tabela.
     * @param key
     * @return true se contiver, false caso contrário
     */
    public boolean contains(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Argument to contains() cannot be null");
        }
        return get(key) != null;
    }

    /**
     * Insere um novo par chave/valor na tabela hash.
     * @param key
     * @param val
     */
    public void put(Key key, Value val) {
        if (N >= M / 2) {
            resize(2 * M); //quando a tabela ta ficando cheia redmensiona
        }

        int j = 0;
        int i = hashLinear(key, j); //indice ini

        // Procura o próximo índice disponível na tabela
        while (keys[i] != null) {
            comparacoes++;
            if (keys[i].equals(key)) { 
                vals[i] = val;
                return;
            }
            j++;
            i = hashLinear(key, j);
        }

        // Insere a chave e o valor
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    /**
     * Remove um par chave/valor da tabela hash.
     * @param key
     */
    public void delete(Key key) {
        comparacoes++;
        if (key == null) {
            throw new IllegalArgumentException("Argument to delete() cannot be null");
        }

        comparacoes++;
        if (!contains(key)) {
            return; 
        }

        int i = hashLinear(key, 0);
        while (!key.equals(keys[i])) {
            i = (i + 1) % M;
        }

        
        keys[i] = null;
        vals[i] = null;
        N--;  // Diminui o número de elementos

        // Reinsere as chaves subsequentes
        i = (i + 1) % M;
        while (keys[i] != null) {
            Key keyToRedo = keys[i];
            Value valToRedo = vals[i];
            keys[i] = null;
            vals[i] = null;
            put(keyToRedo, valToRedo); // Reinsere a chave e o valor
            i = (i + 1) % M;
        }

        // Se a tabela ficar muito vazia, redimensiona
        if (N > 0 && N == M / 8) {
            resize(M / 2);
        }
    }

    /**
     * Busca o valor associado a uma chave.
     * @param key
     * @return o valor ou null se não encontrado
     */
    public Value get(Key key) {
        int j = 0;
        int i = hashLinear(key, j); 

        // Procura a chave
        while (keys[i] != null) {
            comparacoes++;
            if (keys[i].equals(key)) {
                return vals[i]; 
            }
            j++;
            i = hashLinear(key, j); 
        }

        return null; // Chave não foi  encontrada
    }

    /**
     * Para testes: Reseta o contador de comparações.
     */
    public void resetComparacoes() {
        comparacoes = 0;
    }

    /**
     * Para testes: Retorna o número de comparações realizadas.
     */
    public int getComparacoes() {
        return comparacoes;
    }
}

