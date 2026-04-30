import React, { useState } from 'react';
import {
  TextInput,
  View,
  FlatList,
  StatusBar,
  StyleSheet,
  Text,
  TouchableOpacity,
} from 'react-native';

const App = () => {
  const [products, setProducts] = useState([]);
  const [nome, setNome] = useState('');
  const [valor, setValor] = useState('');
  const [data, setData] = useState('');
  const [quantidade, setQuantidade] = useState('');

  const adicionarProduto = () => {
    if (!nome.trim() || !valor.trim() || !data.trim() || !quantidade.trim()) {
      alert('Preencha todos os campos!');
      return;
    }
    const novoProd = {
      id: Date.now().toString(),
      nome: nome,
      valor: valor,
      data: data,
      quantidade: quantidade,
    };
    setProducts([...products, novoProd]);
    setNome('');
    setValor('');
    setData('');
    setQuantidade('');
  };

  const renderItem = ({ item }) => (
    <View style={styles.itemContainer}>
      <Text style={styles.itemText}><Text style={styles.label}>Nome:</Text> {item.nome}</Text>
      <Text style={styles.itemText}><Text style={styles.label}>Valor:</Text> R$ {item.valor}</Text>
      <Text style={styles.itemText}><Text style={styles.label}>Data:</Text> {item.data}</Text>
      <Text style={styles.itemText}><Text style={styles.label}>Quantidade:</Text> {item.quantidade}</Text>
    </View>
  );


  return (
    <View style={styles.container}>


      <View style={styles.titleContainer}>
        <Text style={styles.titleText}>Cadastro de Produtos</Text>
      </View>  

      <View style={styles.inputContainer}>
        <TextInput
          style={styles.inputProduto}
          placeholder="Nome do produto: "
          value={nome}
          onChangeText={setNome}
        />
        <TextInput
          style={styles.inputProduto}
          placeholder="Valor do produto: "
          value={valor}
          onChangeText={setValor}
        />
        <TextInput
          style={styles.inputProduto}
          placeholder="Data do cadastro: "
          value={data}
          onChangeText={setData}
        />
        <TextInput
          style={styles.inputProduto}
          placeholder="Quantidade: "
          value={quantidade}
          onChangeText={setQuantidade}
          keyboardType="numeric"
        />
        <TouchableOpacity 
          style={styles.botaoAdicionar}
          onPress={adicionarProduto}
          activeOpacity={0.7}
        >
          <Text style={styles.textoBotao}>Salvar</Text>
        </TouchableOpacity>
      </View>

      <View style={styles.containerFlatlist}>
        <FlatList
          data={products}
          keyExtractor={(item) => item.id}
          renderItem={renderItem}
          extraData={products}
        />
      </View>
    </View>
  );
};


const styles = StyleSheet.create({
  inputContainer: { 
    backgroundColor: '#ef739c',
    justifyContent: 'center',
    alignItems: 'center',

  },

  container: {
    backgroundColor: '#ee1e9b',
    flex: 1,
    justifyContent: 'center',
    padding: 20,
    alignItems: 'center',
  },

  titleContainer: {
    backgroundColor: '#FF4081',
    width: '100%',
    borderWidth: 1,
    borderColor: '#fff',
    borderRadius: 5,
    padding: 10,
    justifyContent: 'center',
  },
  
  titleText: {
    fontFamily: 'Roboto',
    color: '#fff',
    fontWeight: 'bold',
    fontSize: 31,
    textAlign: 'center',
  },
  
 
  inputProduto: {
    backgroundColor: '#FFF5F8',
    fontFamily: 'fenix',
    height: 45,
    marginBottom: 12,
    fontSize: 16,
    borderWidth: 1,
    borderColor: '#ccc',
    paddingHorizontal: 10,
    borderRadius: 5,
  },
  
  
  containerFlatlist: {
    flex: 2,
    marginHorizontal: 10,
    marginTop: 10,
    padding: 20,
    backgroundColor: '#FFB6C1',
    borderRadius: 6,
    borderWidth: 1,
    borderColor: '#ddd',
    width: '30%',
    justifyContent: 'center',
  },

  itemText: {
    fontFamily: 'fenix',
    fontSize: 16,
    color: '#000103',
    marginBottom: 5,
  },

  label: {
    fontFamily: 'fenix',
    fontWeight: 'bold',
    color: '#000103',
    borderRadius: 7,
    justifyContent: 'center',
    alignItems: 'center',
  },

  textoBotao: {
    fontFamily: 'arial',
    color: '#f3eaee',
    fontSize: 16,
    fontWeight: 'bold',
  },
  botaoAdicionar: {
    backgroundColor: '#a20b6d',
    padding: 15,
    borderRadius: 9,
    alignItems: 'center',
    marginTop: 10,
    width: '100%',
  },
  itemContainer:{
    backgroundColor: '#FFB6C1',
    padding: 15,
    marginBottom: 10,
    borderRadius: 5,
    justifyContent: 'center',
    alignItems: 'center',
  }

});

export default App;