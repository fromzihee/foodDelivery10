<template>

    <v-data-table
        :headers="headers"
        :items="orderSts"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'OrderStsView',
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
            orderSts : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/orderSts'))

            temp.data._embedded.orderSts.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.orderSts = temp.data._embedded.orderSts;
        },
        methods: {
        }
    }
</script>

