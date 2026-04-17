import {useState} from 'react';
import {Text,View,TextInput,TouchableOpacity,StyleSheet} from 'react-native';
export default function Aplicacao(){
const [n1,setN1] = useState()
const [n2,setN2] = useState()
const [n3,setN3] = useState()
const [resultado,setResultado] = useState()
const somar = ()=>{
const r = parseInt(n1) + parseInt(n2) + parseInt(n3) 
setResultado(r)
}
return(
<View style={styles.tudo}>
<View>
<Text style={styles.titulo}> InfoCarro </Text>
</View>
<View style={{margin:15}}>
<Text> 'Modelo do carro:' </Text>
<TextInput
style={styles.caixaDeTexto}
placeholder='Digite aqui o modelo do carro: '
placeholderTextColor='#6f6f6f'
autoFocus={true}
keyboardType={'String'}
onChangeText = {text =>setN1(text)}
/>
</View>
<View style={{margin:15}}>
<Text> 'Valor do Carro' </Text>
<TextInput
style={styles.caixaDeTexto}
placeholder='Digite aqui o valor do carro: '
placeholderTextColor='#6f6f6f'
keyboardType={'numeric'}
onChangeText = {text =>setN2(text)}
/>
</View>

<View style={{margin:15}}>
<Text> 'Ano de Fabricação' </Text>
<TextInput style={styles.caixaDeTexto}
placeholder= 'Digite aqui o ano de fabricação do Carro: '
placeholderTextColor='#6f6f6f'
keyboardType={'numeric'}
onChangeText = {text =>setN3(text)}
/>
</View>

<View style={{margin:15}}>
<TouchableOpacity
style={styles.botao}
onPress={()=>somar()}
activeOpacity={0.5}
>
<Text style={styles.textoBotao}> Salvar </Text>
</TouchableOpacity>
</View>
<View style={{margin:15}}>
<Text style={styles.resposta}> Informações do carro: {resultado} </Text>
</View>
</View>
);
}
const styles = StyleSheet.create({
tudo:{
backgroundColor:'#000',
height:'100%',
width:'100%'
},
titulo:{
color:'#0081f1',
fontSize:25,
textAlign:'center',
marginTop:25,
marginBottom:10
},
caixaDeTexto:{
borderWidth:1,
borderColor:'#0081f1',
color:'#f2f2f2',
borderRadius:40,
paddingLeft: 25,
height:60
},
botao:{
backgroundColor: '#0081f1',
borderRadius: 25,
paddingVertical: 15,
alignItems: 'center'
},
textoBotao:{
color:'#fff',
fontSize:18
},
resposta:{
color:'#0081f1',
fontSize:25,
textAlign:'center',
marginTop:30
}
});