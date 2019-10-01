import Vue from 'vue'
import Router from 'vue-router';
import Appointments from '../components/doctor';
Vue.use(Router);



export default new Router({
    
    mode: 'history',
    base: process.env.BASE_URL,
    routes: [{
            path: '/',
            component: Appointments
        },
                
    ]
    
});