<template>
  <main>
    <div class="text-center mt-3">
      <h1>Foto</h1>
      <form v-if="!showUpdateForm && !showCreateForm" @submit.prevent="getAllFotos">
        <input placeholder="Ricerca per nome" type="text" name="q" v-model="search" />
        <input class="btn btn-light ms-1" style="padding: 1px 10px;" type="submit" value="Cerca" />
      </form>
    </div>

    <div v-if="!showCreateForm && !showUpdateForm">
      <ul class="list-unstyled">
        <li v-for="foto in fotos" :key="foto.id" class="d-flex justify-content-center my-5">
          <div class="card" style="width: 500px;">
            <img :src="foto.photo" alt="Foto" class="card-img-top" />
            <div class="card-body">
              <h3>{{ foto.title }}</h3>
              <hr />
              <p class="card-text">{{ foto.description }}</p>
              <hr />
              <ul class="list-unstyled d-flex justify-content-end">
                <li
                  class="badge text-bg-info ms-1"
                  v-for="categoria in foto.categories"
                  :key="categoria.id"
                >{{ categoria.name }}</li>
              </ul>
            </div>
          </div>
        </li>
      </ul>
    </div>
  </main>
</template>

<script setup>
import { onMounted, ref } from 'vue'
import axios from 'axios'

const API_URL = 'http://localhost:8080/api/v1.0'

const search = ref('')
const fotos = ref(null)

function getAllFotos() {
  let param = ''
  if (search.value != null && search.value.length > 0) param = '?q=' + search.value

  axios
    .get(API_URL + '/fotos' + param)
    .then(res => {
      const data = res.data
      fotos.value = data
    })
    .catch(err => console.log(err))
}
onMounted(() => {
  getAllFotos()
})
</script>
