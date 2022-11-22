<template>

    <v-data-table
        :headers="headers"
        :items="checkitem"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'CheckitemView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "foodid", value: "foodid" },
                { text: "orderid", value: "orderid" },
            ],
            checkitem : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/checkitems'))

            temp.data._embedded.checkitems.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.checkitem = temp.data._embedded.checkitems;
        },
        methods: {
        }
    }
</script>

