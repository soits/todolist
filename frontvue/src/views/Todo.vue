<template>
  <div class="todo">
    <b-card
    header="오늘 해야 할 일"
    style="max-width: 40rem; margin: auto; margin-top: 10vh;"
    class="mb-2"
    border-variant="info"
    align="left">

      <b-form-group id="to-do-input">
        <b-container fluid>
          <b-row class="my-1">
            <b-col sm="10">
              <b-form-input v-model="inputName" type="text" placeholder="새 할 일을 적으세요." />
            </b-col>
            <b-col sm="2">
              <b-button @click="set" variant="outline-primary">추가</b-button>
            </b-col>
          </b-row>
        </b-container>
      </b-form-group>

      <b-list-group v-if="toDoItems && toDoItems.length">
         <b-list-group-item
          v-for="toDoItem of toDoItems"
          v-bind:data="toDoItem.name"
          v-bind:key="toDoItem.id">
          <b-form-checkbox
             v-model="toDoItem.done">
              {{toDoItem.name}}
           </b-form-checkbox>
         </b-list-group-item>
      </b-list-group>
  </b-card>
  <button @click="get">할일조회</button>
  </div>
</template>

<script>
import axios from 'axios'

export default {
   data() {
    return {
      toDoItems: [],
      inputName : ""
    }
  },
  methods: {
    get() {
    var data = {
      items: [        
        { name: 'Foo' },
        { name: 'Bar' },
        { name : 'too' }
      ]
    }        
      this.toDoItems = data.items;
      console.log('this.toDoItems', this.toDoItems);

      /*
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
      */
    },
    set () {
    
      console.log(this.inputName);

      var data = {
        name : ""
      }
      data.name = this.inputName;
      console.log(data);
      this.toDoItems.push(data);
    }
  } 
}

</script>