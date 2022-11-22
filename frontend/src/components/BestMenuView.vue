<template>

    <v-data-table
        :headers="headers"
        :items="bestMenu"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'BestMenuView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "foodid", value: "foodid" },
                { text: "count", value: "count" },
            ],
            bestMenu : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/bestMenus'))

            temp.data._embedded.bestMenus.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.bestMenu = temp.data._embedded.bestMenus;
        },
        methods: {
        }
    }
</script>

