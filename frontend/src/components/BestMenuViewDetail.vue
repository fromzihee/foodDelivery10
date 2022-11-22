<template>

    <v-card outlined>
        <v-card-title>
            BestMenu # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="Foodid" v-model="item.foodid" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Count" v-model="item.count" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'BestMenuViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/bestMenus/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

