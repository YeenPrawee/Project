<template>
    <v-container>
    <div v-if="saveUSC">
      <v-alert outlined dense text type="warning" prominent border="left">
        <strong>ไม่สามารถบันทึกได้</strong> โปรดตรวจสอบข้อมูลอีกครั้ง
      </v-alert>
    </div>

    <div v-if="saveSC">
      <v-alert dense outlined text prominent type="success">บันทึกข้อมูลสำเร็จ</v-alert>
    </div>
        <div>
            <h1 class = "display-2" text--left>ทะเบียนประวัติแพทย์</h1> <br>
            
        <v-form v-model="valid" ref="form">
            <v-col cols="12" md="6">
                    <v-text-field 
                    label="รหัสบัตรประจำตัวประชาชน"
                    v-model="id_card"
                    :rules="[(v) => !!v || 'กรุณากรอกข้อมูล']"
                    required
                    counter
                    maxlength="13"
                    ></v-text-field>
            </v-col>

            <v-row>
                <v-col cols="12" md="2">
                    <v-select 
                    label="คำนำหน้าชื่อ"
                    v-model="doctorprofile.titleId"
                    :items="title"                
                    item-text="title"
                    item-value="id"
                    :rules="[(v) => !!v || 'กรุณากรอกข้อมูล']"
                    required
                     
                    ></v-select>
                </v-col>

                <v-col cols="12" md="4">
                    <v-text-field 
                    label="ชื่อ"
                    v-model="fname"
                    :rules="[(v) => !!v || 'กรุณากรอกข้อมูล']"
                    required
                    ></v-text-field>
                </v-col>

                <v-col cols="12" md="4">
                    <v-text-field 
                    label="นามสกุล"
                    v-model="lname"
                    :rules="[(v) => !!v || 'กรุณากรอกข้อมูล']"
                    required      
                    ></v-text-field>
                </v-col>
            </v-row>
            <v-row>
                <v-col cols="12" md="2">
                    <v-select 
                    label="เพศ"
                    v-model="doctorprofile.sexId"
                    :items="sex"
                    item-text="sex"
                    item-value="id"
                    :rules="[(v) => !!v || 'กรุณากรอกข้อมูล']"
                    required 
                    
                    ></v-select>
                </v-col>

                <v-col >
                    <v-menu
                        v-model="menu1"
                        :close-on-content-click="false"
                        full-width
                        max-width="290"
                        >
                        <template v-slot:activator="{ on }">
                            <v-text-field
                            :value="computedDateFormattedMomentjs"
                            clearable
                            label="วันเกิด"
                            readonly
                            
                            v-on="on"
                            locale="th"
                            ></v-text-field>
                        </template>
                        <v-date-picker
                        locale="th"
                            v-model="birthday"
                            @change="menu1 = false"
                        ></v-date-picker>
                    </v-menu>
                </v-col>

                <v-col cols="12" md="1">
                    <v-text-field 
                    label="อายุ" 
                    suffix="ปี"
                    v-model="age"
                    :rules="[(v) => !!v || 'กรุณากรอกข้อมูล']"
                    required
                    ></v-text-field>
                </v-col>                
            </v-row>
            <v-row>
                <v-col cols="12" md="4">
                    <v-select 
                    label="จังหวัด"
                    v-model="doctorprofile.provinceId"
                    :items="province" 
                    item-text="province"
                    item-value="id"
                    :rules="[(v) => !!v || 'กรุณากรอกข้อมูล']"
                    required 
                    
                    ></v-select>
                </v-col>

                <v-col cols="12" md="6">
                    <v-text-field 
                        label="ที่อยู่"
                        v-model="address"
                        :rules="[(v) => !!v || 'กรุณากรอกข้อมูล']"
                     required
                    ></v-text-field>
                 </v-col>
            </v-row>

            <v-row>
                <v-col cols="12" md="5">
                    <v-text-field 
                    label="จบการศึกษาจาก"
                    v-model="graduate"
                    :rules="[(v) => !!v || 'กรุณากรอกข้อมูล']"
                    required
                    ></v-text-field>
                </v-col>

                <v-col cols="12" md="5">
                    <v-select 
                    label="ความเชี่ยวชาญ"
                    v-model="doctorprofile.expertiseId"
                    :items="expertise" 
                    item-text="expertise"
                    item-value="id"
                    :rules="[(v) => !!v || 'กรุณากรอกข้อมูล']"
                    required 
                    
                    ></v-select>
                </v-col>
            </v-row>

            <v-col cols="12" md="6">
                <v-textarea
                v-model="exp"
                name="input-7-4"
                label="ประวัติการทำงาน"
                :rules="[(v) => !!v || 'กรุณากรอกข้อมูล']"
                required                
                ></v-textarea>
            </v-col>
    
            <div class="text-center">
                <v-btn @click="saveDoctors" :class="{red : !valid,green : valid}" color="darken-2" dark >SAVE</v-btn>
                <v-btn style="margin-left: 15px;" @click="clear">clear</v-btn>
            </div>

        </v-form>

        </div>
    </v-container>
</template>


<script>
import http from "../http-common"
import moment from 'moment'

export default {
    computed: {
      computedDateFormattedMomentjs () {
        return this.birthday ? moment(this.birthday).format('dddd Do, MMMM YYYY') : ''
      },
    }, 
    name: "doctorprofile",
    data(){
        return{
            doctorprofile:{
                titleId: "",
                sexId:"",
                expertiseId:"",
                provinceId:"",
            },
            fname:"",
            lname:"",
            age:"",
            exp:"",
            graduate:"",
            address:"",
            id_card:"",
            saveSC:"",
            saveUSC:"",
            valid: false,
                        
            menu: false,
            modal: false,
            menu2: false,
            birthday : "",
            menu1: false,

            title:[],
            sex:[],
            expertise:[],
            province:[],
        };
    },
    methods:{
        /* eslint-disable no-console */
        
        // ดึงข้อมูล Title ใส่ combobox
        getTitle() {
        http
            .get("/title")
            .then(response => {
            this.title = response.data;
            console.log(response.data);
            })
            .catch(e => {
            console.log(e);
            });
        },
        // ดึงข้อมูล sex ใส่ combobox
        getSex() {
        http
            .get("/sex")
            .then(response => {
            this.sex = response.data;
            console.log(response.data);
            })
            .catch(e => {
            console.log(e);
            });
        },
        // ดึงข้อมูล expertise ใส่ combobox
        getExpertise() {
        http
            .get("/expertise")
            .then(response => {
            this.expertise = response.data;
            console.log(response.data);
            })
            .catch(e => {
            console.log(e);
            });
        },
        getProvince() {
        http
            .get("/province")
            .then(response => {
            this.province = response.data;
            console.log(response.data);
            })
            .catch(e => {
            console.log(e);
            });
        },
        
        clear() {
            this.$refs.form.reset();
            this.saveSC=false;
            this.saveUSC=false;
        },

        // function เมื่อกดปุ่ม save
        saveDoctors() {
      console.log(this.doctors);
      http
        .post(
          "/doctorprofile/" + this.address
          + "/" + this.age
          + "/" + this.birthday
          + "/" + this.exp
          + "/" + this.fname
          + "/" + this.graduate
          + "/" + this.lname
          + "/" + this.id_card
          + "/" + this.doctorprofile.expertiseId
          + "/" + this.doctorprofile.sexId
          + "/" + this.doctorprofile.titleId 
          + "/" + this.doctorprofile.provinceId
        )
       .then(response => {
          console.log(response);
          this.saveSC=true;
          this.saveUSC=false;
        })
        .catch(e => {
          console.log(e);
          this.saveSC=false;
          this.saveUSC=true;
        });
      this.submitted = true;
    },
        refreshList() {
        this.getTitle();
        this.getSex();
        this.getExpertise();
        this.getProvince();
        },
        /* eslint-enable no-console */
    },
    
    mounted(){
        this.getTitle();
        this.getSex();
        this.getExpertise();
        this.getProvince();
    }
};
</script>