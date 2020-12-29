<template>
  <div>
    <div ref="main" style="width: 600px;height:400px;"></div>
  </div>
</template>

<script>
import {queryBrandEcharts} from "../../../api/brand";

export default {
  name: "brandEcharts",
  data() {
    return {
      option: {
        xAxis: {
          type: 'category',
          data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
        },
        yAxis: {
          type: 'value'
        },
        series: [{
          data: [120, 500, 150, 80, 70, 110, 130],
          type: 'bar'
        }]
      }
    }
  },

  methods: {
    /*初始化echarts*/
    drawLine() {
      let myChart = this.$echarts.init(this.$refs.main)
      myChart.setOption(this.option);
    },
    /*获取品牌数据*/
    queryBrand() {
      queryBrandEcharts().then(result=>{

      })
    }
  },

  mounted() {
    this.queryBrand();
    this.drawLine();
  }
}
</script>

<style scoped>

</style>