<template>
  <div id="example">
    <h1>This is Api GET Test</h1>

    <br/>
    <b>데이터가져오기</b>
    <button v-on:click="get()">클릭</button>
    

  </div>
    
</template>


<script>

const method = {
  get : function(){
    console.log('test');
  }
};

export default method;

</script>