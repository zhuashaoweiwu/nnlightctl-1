webpackJsonp([31],{f8ay:function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});a("9GaH");var l=a("ZgHW"),n=a("PJh5"),r=a.n(n),o={name:"Elebox",data:function(){return{isSynData:!0,formInline:{elebox:"",states:"",level:"",uid:""},tableData:[{state:"良好",alarmLevel:"三级警报",codeNumber:"控制柜一/上海市普陀区金沙江路 1518 弄",alarmSource:"上海xxxx",name:"XXX警报",ctype:"普通灯警报",gmtCreated:"e222323",gmtUpdated:"201-121",nnlightctlAlarmConfigId:"11",alarmTime:"2016-05-02",msg:"事件报警",alarmCount:"3"},{state:"良好",alarmLevel:"三级警报",codeNumber:"控制柜一/上海市普陀区金沙江路 1518 弄",alarmSource:"上海xxxx",name:"XXX警报",ctype:"普通灯警报",gmtCreated:"e222323",gmtUpdated:"201-121",nnlightctlAlarmConfigId:"11",alarmTime:"2016-05-02",msg:"事件报警",alarmCount:"3"},{state:"良好",alarmLevel:"三级警报",codeNumber:"控制柜一/上海市普陀区金沙江路 1518 弄",alarmSource:"上海xxxx",name:"XXX警报",ctype:"普通灯警报",gmtCreated:"e222323",gmtUpdated:"201-121",nnlightctlAlarmConfigId:"11",alarmTime:"2016-05-02",msg:"事件报警",alarmCount:"3"},{state:"良好",alarmLevel:"三级警报",codeNumber:"控制柜一/上海市普陀区金沙江路 1518 弄",alarmSource:"上海xxxx",name:"XXX警报",ctype:"普通灯警报",gmtCreated:"e222323",gmtUpdated:"201-121",nnlightctlAlarmConfigId:"11",alarmTime:"2016-05-02",msg:"事件报警",alarmCount:"3"}],currentPage3:5}},computed:{},methods:{getListAlarm:function(e,t){var a=this;Object(l.d)(e,t).then(function(e){console.log(e,"初始化shuju"),a.tableData=e.data})},dateFormat:function(e,t){var a=e[t.property];return void 0==a?"":r()(a).format("YYYY-MM-DD HH:mm:ss")},onSubmit:function(){console.log("submit!")},onResume:function(){console.log("resume")},toggleSelection:function(e){var t=this;e?e.forEach(function(e){t.$refs.multipleTable.toggleRowSelection(e)}):this.$refs.multipleTable.clearSelection()},handleSelectionChange:function(e){this.multipleSelection=e},handleSizeChange:function(e){console.log("每页 "+e+" 条")},handleCurrentChange:function(e){console.log("当前页: "+e)}},created:function(){this.getListAlarm(1,20)}},c={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{attrs:{id:"EleboxWarning"}},[a("div",{attrs:{id:"dataTable"}},[a("div",{staticClass:"operator"},[a("el-checkbox",{model:{value:e.isSynData,callback:function(t){e.isSynData=t},expression:"isSynData"}},[e._v("仅同步未完成数据")])],1),e._v(" "),a("el-table",{staticStyle:{width:"100%"},attrs:{data:e.tableData},on:{"selection-change":e.handleSelectionChange}},[a("el-table-column",{attrs:{type:"selection",width:"55"}}),e._v(" "),a("el-table-column",{attrs:{prop:"state",label:"状态",width:"80"}}),e._v(" "),a("el-table-column",{attrs:{prop:"alarmLevel",label:"等级",width:"80"}}),e._v(" "),a("el-table-column",{attrs:{prop:"codeNumber",label:"控制柜/区域",width:"120"}}),e._v(" "),a("el-table-column",{attrs:{prop:"alarmSource",label:"来自",width:"120"}}),e._v(" "),a("el-table-column",{attrs:{prop:"gmtCreated",formatter:e.dateFormat,label:"创建时间",width:"150"}}),e._v(" "),a("el-table-column",{attrs:{prop:"gmtUpdated",formatter:e.dateFormat,label:"更新时间",width:"150"}}),e._v(" "),a("el-table-column",{attrs:{prop:"ctype",label:"类型"}}),e._v(" "),a("el-table-column",{attrs:{prop:"nnlightctlAlarmConfigId",label:"警報配置ID"}}),e._v(" "),a("el-table-column",{attrs:{prop:"alarmTime",formatter:e.dateFormat,label:"报警/解除时间"}}),e._v(" "),a("el-table-column",{attrs:{prop:"msg",label:"消息"}}),e._v(" "),a("el-table-column",{attrs:{prop:"alarmCount",label:"次数"}})],1),e._v(" "),a("div",{staticClass:"pagelist-block"},[a("el-pagination",{attrs:{"current-page":e.currentPage3,"page-size":10,layout:"prev, pager, next, jumper",total:39},on:{"size-change":e.handleSizeChange,"current-change":e.handleCurrentChange,"update:currentPage":function(t){e.currentPage3=t}}})],1)],1)])},staticRenderFns:[]};var m=a("VU/8")(o,c,!1,function(e){a("hrYB")},"data-v-712f2cfb",null);t.default=m.exports},hrYB:function(e,t){}});
//# sourceMappingURL=31.3e52deaa3a17ce37601f.js.map