<template>
  <main>

    <div class="text-center mt-3">
      <img src="../assets/images/LightPhoto.png" alt="LightPHOTO" style="width: 300px" />
      <form v-if="!showUpdateForm && !showCreateForm" @submit.prevent="getAllFotos" class="mt-4">
        <input placeholder="Ricerca per nome" type="text" name="q" v-model="search" />
        <input class="btn btn-light ms-1" style="padding: 1px 10px;" type="submit" value="Cerca" />
      </form>
    </div>

    <div v-if="!showCreateForm && !showUpdateForm">
      <ul class="list-unstyled">
        <li v-for="foto in fotos" :key="foto.id" class="d-flex justify-content-center">
          <div class="card mt-5" style="width: 500px;" v-if="foto.visibility">
            <img :src="foto.photo" alt="Foto" class="card-img-top" />
            <div class="card-body">
              <h3 class="fw-bolder fst-italic">{{ foto.title }}</h3>
              <hr />
              <p class="card-text">{{ foto.description }}</p>
              <hr />
              <ul class="list-unstyled d-flex justify-content-end">
                <li class="badge ms-1 fst-italic fst-light" v-for="(categoria, index) in foto.categories"
                  :key="categoria.id" :class="index % 2 === 0 ? 'text-bg-secondary' : 'text-bg-dark'">{{ categoria.name }}
                </li>
              </ul>
            </div>
          </div>
        </li>
      </ul>
    </div>

    <div class="container bg-secondary my-5 p-5" style="width: 500px; border-radius: 20px;">
      <div class="text-center">
        <img src="../assets/images/LightPhoto.png" alt="LightPHOTO" style="width: 250px;" />
      </div>
      <h3 class="text-center">Contact Form</h3>
      <form @submit.prevent="storeMessage()">
        <div class="form-group my-3">
          <label for="name">Nome:</label>
          <input type="text" class="form-control" id="name" name="name" placeholder="Inserisci il tuo nome"
            v-model="newMessage.name">
        </div>

        <div class="form-group my-3">
          <label for="email">Email:</label>
          <input type="text" class="form-control" id="email" name="email" placeholder="Inserisci la tua email"
            v-model="newMessage.email">
        </div>

        <div class="form-group my-3">
          <label for="subject">Testo:</label>
          <textarea class="form-control" id="subject" name="subject" placeholder="Scrivici... se osi" style="height:200px"
            v-model="newMessage.subject"></textarea>
        </div>

        <button type="submit" class="btn btn-primary">Invia</button>
      </form>
    </div>

  </main>
</template>

<script setup>
import { onMounted, ref } from 'vue'
import axios from 'axios'

const API_URL = 'http://localhost:8080/api/v1.0'

const search = ref('')
const fotos = ref(null)
const emptyMessage = {
  text: null,
  email: null
};
const newMessage = ref({ ...emptyMessage });

function storeMessage() {
  axios.post(API_URL + "/store", newMessage.value)
    .then(() => {
      newMessage.value = ref({ ...newMessage });
    })
    .catch(err => console.log(err));
}

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
