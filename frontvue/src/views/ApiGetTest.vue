<template>
  <div id="example">
    123
    <h1>This is Api GET Test</h1>

    <br/>
    <b>데이터가져오기</b>
    <button @click="get">클릭</button>

  <ul v-if="toDoItems && toDoItems.length">
    <li v-for="toDoItem in toDoItems" v-bind:key="toDoItem">
      {{toDoItem.title}}
    </li> 
  </ul>


  {{ key1 }}

  </div>    
</template>


<script>
import axios from 'axios'

export default {
   data() {
    return {
      toDoItems: [
        1
      ],
      key1 : "TEST"
    }
  },
  methods: {
    get() {
      this.key1 = "click";
      console.log('test2')
      axios.get('http://192.168.62.45:5000/todo', {
          params: {       
          }
      }).then(function (response) {
        console.log(response);
        this.toDoItems = response.data.map(r => r.data);
      }).catch(function (error) {
        console.log(error);
      }).then(function () {
        // always executed
      })
    }
  } 
}
</script>