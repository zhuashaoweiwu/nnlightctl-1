webpackJsonp([18],{XjZU:function(e,t){},fCNe:function(e,t,l){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var a=l("EMlb"),i={name:"GlobalRegion",data:function(){return{listCountry:[],listProvince:[],listCity:[],countryMultipleTable:[],provinceMultipleTable:[],cityyMultipleTable:[],addNewObjShow:!1,dialogTitle:["国家","省份","城市"],dialogText:["添加","修改"],textType:0,dialogType:0,addObj:{name:null,code:null,mem:null,longitude:null,latitude:null,timeZone:null},addCityrules:{name:[{required:!0,message:"填写内容不得为空",trigger:"blur"}],code:[{required:!0,message:"填写内容不得为空",trigger:"blur"}],mem:[{required:!0,message:"填写内容不得为空",trigger:"blur"}],longitude:[{required:!0,message:"填写内容不得为空",trigger:"blur"}],latitude:[{required:!0,message:"填写内容不得为空",trigger:"blur"}],timeZone:[{required:!0,message:"填写内容不得为空",trigger:"blur"}]}}},methods:{getListCountry:function(){var e=this;Object(a.k)().then(function(t){e.listCountry=t.data}).catch(function(e){console.log(e)})},getListProvince:function(){var e=this;Object(a.m)().then(function(t){e.listProvince=t.data}).catch(function(e){console.log(e)})},getListCity:function(){var e=this;Object(a.j)().then(function(t){e.listCity=t.data}).catch(function(e){console.log(e)})},editRow:function(e,t){var l=this;this.textType=1,this.dialogType=t,0===t?Object(a.g)(this.listCountry[e].codeNumber).then(function(e){l.addObj.name=e.data[0].countryName,l.addObj.code=e.data[0].codeNumber,l.addObj.mem=e.data[0].mem,l.addNewObjShow=!0}).catch(function(e){console.log(e)}):1===t?Object(a.h)(this.listProvince[e].codeNumber).then(function(e){l.addObj.name=e.data[0].provinceName,l.addObj.code=e.data[0].codeNumber,l.addObj.mem=e.data[0].mem,l.addNewObjShow=!0}).catch(function(e){console.log(e)}):2===t&&Object(a.f)(this.listCity[e].codeNumber).then(function(e){l.addObj.name=e.data[0].cityName,l.addObj.code=e.data[0].codeNumber,l.addObj.mem=e.data[0].mem,l.addObj.longitude=e.data[0].longitude,l.addObj.latitude=e.data[0].latitude,l.addObj.timeZone=e.data[0].timeZone,l.addNewObjShow=!0}).catch(function(e){console.log(e)})},deleteRow:function(){},addNewObj:function(e){this.dialogType=e,this.textType=0,this.addNewObjShow=!0},goRules:function(e){var t=this;this.$refs[e].validate(function(e){e?t.onSubmit():console.log("error submit!!")})},onSubmit:function(){var e=this,t={},l=void 0;l=0===this.textType?"添加成功":"修改成功",0===this.dialogType?(t.countryName=this.addObj.name,t.codeNumber=this.addObj.code,t.mem=this.addObj.mem,Object(a.c)(t).then(function(t){e.$message({type:"success",message:l}),e.getListCountry(),e.addNewObjShow=!1,e.handleCloseDialog()}).catch(function(e){console.log(e)})):1===this.dialogType?(t.provinceName=this.addObj.name,t.codeNumber=this.addObj.code,t.mem=this.addObj.mem,Object(a.d)(t).then(function(t){e.$message({type:"success",message:l}),e.getListProvince(),e.addNewObjShow=!1,e.addObj={name:null,code:null,mem:null,longitude:null,latitude:null,timeZone:null},e.$refs.rulesform.resetFields()}).catch(function(e){console.log(e)})):2===this.dialogType&&(t.cityName=this.addObj.name,t.codeNumber=this.addObj.code,t.longitude=this.addObj.longitude,t.latitude=this.addObj.latitude,t.timeZone=this.addObj.timeZone,t.mem=this.addObj.mem,Object(a.b)(t).then(function(t){e.$message({type:"success",message:l}),e.getListCity(),e.addNewObjShow=!1,e.addObj={name:null,code:null,mem:null,longitude:null,latitude:null,timeZone:null},e.$refs.rulesform.resetFields()}).catch(function(e){console.log(e)}))},handleCloseDialog:function(e){this.addObj={name:null,code:null,mem:null,longitude:null,latitude:null,timeZone:null},this.$refs.rulesform.resetFields(),console.log(this.addObj),e()}},created:function(){this.getListCountry(),this.getListProvince(),this.getListCity()},destroyed:function(){}},o={render:function(){var e=this,t=e.$createElement,l=e._self._c||t;return l("div",{staticClass:"project-container"},[l("div",{staticClass:"region-title"},[e._v("\n    全球统计数据\n  ")]),e._v(" "),l("div",[l("div",{staticClass:"region-block region-block1 clearfix"},[l("div",{staticClass:"data-block"},[l("div",{staticClass:"data-block-title"},[e._v("\n          国家\n          "),e._v(" "),l("a",{staticClass:"f-r",on:{click:function(t){e.addNewObj(0)}}},[l("i",{staticClass:"iconfont "},[e._v("")]),e._v("添加")])]),e._v(" "),l("el-table",{ref:"countryMultipleTable",staticStyle:{width:"100%"},attrs:{data:e.listCountry,"tooltip-effect":"dark",height:"300px","header-row-class-name":"datalist-header"}},[l("el-table-column",{attrs:{prop:"codeNumber",label:"编码",width:"100"}}),e._v(" "),l("el-table-column",{attrs:{prop:"countryName",label:"国家",width:"120"}}),e._v(" "),l("el-table-column",{attrs:{prop:"mem",label:"备注"}}),e._v(" "),l("el-table-column",{attrs:{fixed:"right",label:"操作",width:"80"},scopedSlots:e._u([{key:"default",fn:function(t){return[l("el-button",{attrs:{type:"text",size:"small"},nativeOn:{click:function(l){l.preventDefault(),e.editRow(t.$index,0)}}},[e._v("\n                编辑\n              ")])]}}])})],1)],1),e._v(" "),l("div",{staticClass:"data-block"},[l("div",{staticClass:"data-block-title"},[e._v("\n          省份\n          "),e._v(" "),l("a",{staticClass:"f-r",on:{click:function(t){e.addNewObj(1)}}},[l("i",{staticClass:"iconfont "},[e._v("")]),e._v("添加")])]),e._v(" "),l("el-table",{ref:"provinceMultipleTable",staticStyle:{width:"100%"},attrs:{data:e.listProvince,"tooltip-effect":"dark",height:"300px","header-row-class-name":"datalist-header"}},[l("el-table-column",{attrs:{prop:"codeNumber",label:"编码",width:"100"}}),e._v(" "),l("el-table-column",{attrs:{prop:"provinceName",label:"省份",width:"120"}}),e._v(" "),l("el-table-column",{attrs:{prop:"mem",label:"备注"}}),e._v(" "),l("el-table-column",{attrs:{fixed:"right",label:"操作",width:"80"},scopedSlots:e._u([{key:"default",fn:function(t){return[l("el-button",{attrs:{type:"text",size:"small"},nativeOn:{click:function(l){l.preventDefault(),e.editRow(t.$index,1)}}},[e._v("\n                编辑\n              ")])]}}])})],1)],1)]),e._v(" "),l("div",{staticClass:"region-block clearfix"},[l("div",{staticClass:"data-block"},[l("div",{staticClass:"data-block-title"},[e._v("\n          城市\n          "),e._v(" "),l("a",{staticClass:"f-r",on:{click:function(t){e.addNewObj(2)}}},[l("i",{staticClass:"iconfont "},[e._v("")]),e._v("添加")])]),e._v(" "),l("el-table",{ref:"cityyMultipleTable",staticStyle:{width:"100%"},attrs:{data:e.listCity,"tooltip-effect":"dark",height:"300px","header-row-class-name":"datalist-header"}},[l("el-table-column",{attrs:{prop:"codeNumber",label:"编码",width:"100"}}),e._v(" "),l("el-table-column",{attrs:{prop:"cityName",label:"城市",width:"120"}}),e._v(" "),l("el-table-column",{attrs:{prop:"longitude",label:"经度",width:"80"}}),e._v(" "),l("el-table-column",{attrs:{prop:"latitude",label:"纬度",width:"80"}}),e._v(" "),l("el-table-column",{attrs:{prop:"timeZone ",label:"时区",width:"80"}}),e._v(" "),l("el-table-column",{attrs:{prop:"mem",label:"备注"}}),e._v(" "),l("el-table-column",{attrs:{fixed:"right",label:"操作",width:"120"},scopedSlots:e._u([{key:"default",fn:function(t){return[l("el-button",{attrs:{type:"text",size:"small"},nativeOn:{click:function(l){l.preventDefault(),e.editRow(t.$index,2)}}},[e._v("\n                编辑\n              ")])]}}])})],1)],1)])]),e._v(" "),l("el-dialog",{attrs:{title:e.dialogText[e.textType]+e.dialogTitle[e.dialogType],visible:e.addNewObjShow,"close-on-click-modal":!1,"close-on-press-escape":!1,center:"","before-close":e.handleCloseDialog},on:{"update:visible":function(t){e.addNewObjShow=t}}},[l("el-form",{ref:"rulesform",attrs:{model:e.addObj,rules:e.addCityrules,"label-width":"50px"}},[l("el-form-item",{attrs:{label:e.dialogTitle[e.dialogType],prop:"name",required:""}},[l("el-input",{attrs:{placeholder:"请输入内容"},model:{value:e.addObj.name,callback:function(t){e.$set(e.addObj,"name",t)},expression:"addObj.name"}})],1),e._v(" "),l("el-form-item",{attrs:{label:"编码",prop:"code",required:""}},[l("el-input",{attrs:{placeholder:"请输入内容"},model:{value:e.addObj.code,callback:function(t){e.$set(e.addObj,"code",t)},expression:"addObj.code"}})],1),e._v(" "),2==e.dialogType?l("div",[l("el-form-item",{attrs:{label:"经度",prop:"longitude",required:""}},[l("el-input",{attrs:{placeholder:"请输入内容"},model:{value:e.addObj.longitude,callback:function(t){e.$set(e.addObj,"longitude",t)},expression:"addObj.longitude"}})],1),e._v(" "),l("el-form-item",{attrs:{label:"纬度",prop:"latitude",required:""}},[l("el-input",{attrs:{placeholder:"请输入内容"},model:{value:e.addObj.latitude,callback:function(t){e.$set(e.addObj,"latitude",t)},expression:"addObj.latitude"}})],1),e._v(" "),l("el-form-item",{attrs:{label:"时区",prop:"timeZone",required:""}},[l("el-input",{attrs:{placeholder:"请输入内容"},model:{value:e.addObj.timeZone,callback:function(t){e.$set(e.addObj,"timeZone",t)},expression:"addObj.timeZone"}})],1)],1):e._e(),e._v(" "),l("el-form-item",{attrs:{label:"备注"}},[l("el-input",{attrs:{type:"textarea",placeholder:"请输入内容"},model:{value:e.addObj.mem,callback:function(t){e.$set(e.addObj,"mem",t)},expression:"addObj.mem"}})],1)],1),e._v(" "),l("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[l("el-button",{on:{click:function(t){e.addNewObjShow=!1}}},[e._v("取 消")]),e._v(" "),l("el-button",{attrs:{type:"primary"},on:{click:function(t){e.goRules("rulesform")}}},[e._v("确 定")])],1)],1)],1)},staticRenderFns:[]};var d=l("VU/8")(i,o,!1,function(e){l("jdYd"),l("XjZU")},"data-v-477a7270",null);t.default=d.exports},jdYd:function(e,t){}});
//# sourceMappingURL=18.822ddfd5d8ee567e72ff.js.map