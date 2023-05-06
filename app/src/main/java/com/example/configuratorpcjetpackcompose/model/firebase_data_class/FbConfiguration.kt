package com.example.configuratorpcjetpackcompose.model.firebase_data_class

import com.example.configuratorpcjetpackcompose.model.data_class.Configuration
import com.example.configuratorpcjetpackcompose.model.data_class.Cpu
import com.google.firebase.firestore.PropertyName

data class FbConfiguration(
    @PropertyName("cpu_id")
    var cpuId: String = "",
    @PropertyName("motherboard_id")
    var motherboardId: String = "",
    @PropertyName("dimm_ids_list")
    var dimmIdsList: MutableList<String> = mutableListOf(),
    @PropertyName("sodimm_ids_list")
    var soDimmIdsList: MutableList<String> = mutableListOf(),
    @PropertyName("power_supply_unit_id")
    var powerSupplyUnitId: String = "",
    @PropertyName("sound_card_id")
    var soundCardId: String = "",
    @PropertyName("video_card_ids_list")
    var videoCardIdsList: MutableList<String> = mutableListOf(),
    @PropertyName("cooler_for_case_ids_list")
    var coolerForCaseIdsList: MutableList<String> = mutableListOf(),
    @PropertyName("cooler_for_cpu_id")
    var coolerForCpuId: String = "",
    @PropertyName("case_id")
    var caseId: String = "",
    @PropertyName("monitor_ids_list")
    var monitorIdsList: MutableList<String> = mutableListOf(),
    @PropertyName("hard_drive_ids_list")
    var hardDriveIdsList: MutableList<String> = mutableListOf(),
    @PropertyName("ssd_ids_list")
    var ssdIdsList: MutableList<String> = mutableListOf(),
)

fun FbConfiguration.toConfiguration(cpu: Cpu): Configuration {
    return Configuration(
        cpu = Cpu(
            idAccessory = this.cpuId,
            nameAccessory = cpu._nameAccessory,
            priceAccessory = cpu._priceAccessory,
            descriptionAccessory = cpu._descriptionAccessory,
            uriAccessory = cpu._uriAccessory,
            cpu = cpu
        ),
    )
}