
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import OrderManager from "./components/listers/OrderCards"
import OrderDetail from "./components/listers/OrderDetail"
import PaymentManager from "./components/listers/PaymentCards"
import PaymentDetail from "./components/listers/PaymentDetail"

import OrderMangeManager from "./components/listers/OrderMangeCards"
import OrderMangeDetail from "./components/listers/OrderMangeDetail"

import BestMenuView from "./components/BestMenuView"
import BestMenuViewDetail from "./components/BestMenuViewDetail"
import NotificationLogManager from "./components/listers/NotificationLogCards"
import NotificationLogDetail from "./components/listers/NotificationLogDetail"

import OrderStsView from "./components/OrderStsView"
import OrderStsViewDetail from "./components/OrderStsViewDetail"
import DeliveryManager from "./components/listers/DeliveryCards"
import DeliveryDetail from "./components/listers/DeliveryDetail"

import CheckitemView from "./components/CheckitemView"
import CheckitemViewDetail from "./components/CheckitemViewDetail"

export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/orders',
                name: 'OrderManager',
                component: OrderManager
            },
            {
                path: '/orders/:id',
                name: 'OrderDetail',
                component: OrderDetail
            },
            {
                path: '/payments',
                name: 'PaymentManager',
                component: PaymentManager
            },
            {
                path: '/payments/:id',
                name: 'PaymentDetail',
                component: PaymentDetail
            },

            {
                path: '/orderManges',
                name: 'OrderMangeManager',
                component: OrderMangeManager
            },
            {
                path: '/orderManges/:id',
                name: 'OrderMangeDetail',
                component: OrderMangeDetail
            },

            {
                path: '/bestMenus',
                name: 'BestMenuView',
                component: BestMenuView
            },
            {
                path: '/bestMenus/:id',
                name: 'BestMenuViewDetail',
                component: BestMenuViewDetail
            },
            {
                path: '/notificationLogs',
                name: 'NotificationLogManager',
                component: NotificationLogManager
            },
            {
                path: '/notificationLogs/:id',
                name: 'NotificationLogDetail',
                component: NotificationLogDetail
            },

            {
                path: '/orderSts',
                name: 'OrderStsView',
                component: OrderStsView
            },
            {
                path: '/orderSts/:id',
                name: 'OrderStsViewDetail',
                component: OrderStsViewDetail
            },
            {
                path: '/deliveries',
                name: 'DeliveryManager',
                component: DeliveryManager
            },
            {
                path: '/deliveries/:id',
                name: 'DeliveryDetail',
                component: DeliveryDetail
            },

            {
                path: '/checkitems',
                name: 'CheckitemView',
                component: CheckitemView
            },
            {
                path: '/checkitems/:id',
                name: 'CheckitemViewDetail',
                component: CheckitemViewDetail
            },


    ]
})
