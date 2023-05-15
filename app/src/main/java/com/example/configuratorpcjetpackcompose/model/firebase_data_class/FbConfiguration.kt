package com.example.configuratorpcjetpackcompose.model.firebase_data_class

import com.example.configuratorpcjetpackcompose.model.data_class.Case
import com.example.configuratorpcjetpackcompose.model.data_class.Configuration
import com.example.configuratorpcjetpackcompose.model.data_class.CoolerForCase
import com.example.configuratorpcjetpackcompose.model.data_class.CoolerForCpu
import com.example.configuratorpcjetpackcompose.model.data_class.Cpu
import com.example.configuratorpcjetpackcompose.model.data_class.Dimm
import com.example.configuratorpcjetpackcompose.model.data_class.HardDrive
import com.example.configuratorpcjetpackcompose.model.data_class.Monitor
import com.example.configuratorpcjetpackcompose.model.data_class.Motherboard
import com.example.configuratorpcjetpackcompose.model.data_class.PowerSupplyUnit
import com.example.configuratorpcjetpackcompose.model.data_class.SoDimm
import com.example.configuratorpcjetpackcompose.model.data_class.SoundCard
import com.example.configuratorpcjetpackcompose.model.data_class.Ssd
import com.example.configuratorpcjetpackcompose.model.data_class.VideoCard
import com.google.firebase.firestore.PropertyName

data class FbConfiguration(
    @PropertyName("name_configuration")
    var name: String = "",
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
    @PropertyName("is_favorite")
    var isFavorite: Boolean = false
)

fun FbConfiguration.toConfiguration(
    nameConfiguration: String,
    cpu: Cpu,
    motherboard: Motherboard,
    powerSupplyUnit: PowerSupplyUnit,
    coolerForCpu: CoolerForCpu,
    soundCard: SoundCard,
    case: Case,
    dimmIdsList: MutableList<Dimm>,
    soDimmIdsList: MutableList<SoDimm>,
    videoCardIdsList: MutableList<VideoCard>,
    coolerForCaseIdsList: MutableList<CoolerForCase>,
    monitorIdsList: MutableList<Monitor>,
    hardDriveIdsList: MutableList<HardDrive>,
    ssdIdsList: MutableList<Ssd>,
    isFavorite: Boolean
): Configuration {

    var dimmList = mutableListOf<Dimm>()
    var soDimmList = mutableListOf<SoDimm>()
    var videoCardList = mutableListOf<VideoCard>()
    var coolerForCaseList = mutableListOf<CoolerForCase>()
    var monitorList = mutableListOf<Monitor>()
    var hardDriveList = mutableListOf<HardDrive>()
    var ssdList = mutableListOf<Ssd>()

    dimmIdsList.forEach { dimm ->
        dimmList.add(
            Dimm(
                idAccessory = dimm._idAccessory,
                nameAccessory = dimm._nameAccessory,
                priceAccessory = dimm._priceAccessory,
                descriptionAccessory = dimm._descriptionAccessory,
                uriAccessory = dimm._uriAccessory,
                dimm = dimm
            )
        )
    }

    ssdIdsList.forEach { ssd ->
        ssdList.add(
            Ssd(
                idAccessory = ssd._idAccessory,
                nameAccessory = ssd._nameAccessory,
                priceAccessory = ssd._priceAccessory,
                descriptionAccessory = ssd._descriptionAccessory,
                uriAccessory = ssd._uriAccessory,
                ssd = ssd
            )
        )
    }

    hardDriveIdsList.forEach { hardDrive ->
        hardDriveList.add(
            HardDrive(
                idAccessory = hardDrive._idAccessory,
                nameAccessory = hardDrive._nameAccessory,
                priceAccessory = hardDrive._priceAccessory,
                descriptionAccessory = hardDrive._descriptionAccessory,
                uriAccessory = hardDrive._uriAccessory,
                hardDrive = hardDrive
            )
        )
    }

    monitorIdsList.forEach { monitor ->
        monitorList.add(
            Monitor(
                idAccessory = monitor._idAccessory,
                nameAccessory = monitor._nameAccessory,
                priceAccessory = monitor._priceAccessory,
                descriptionAccessory = monitor._descriptionAccessory,
                uriAccessory = monitor._uriAccessory,
                monitor = monitor
            )
        )
    }

    soDimmIdsList.forEach { soDimm ->
        soDimmList.add(
            SoDimm(
                idAccessory = soDimm._idAccessory,
                nameAccessory = soDimm._nameAccessory,
                priceAccessory = soDimm._priceAccessory,
                descriptionAccessory = soDimm._descriptionAccessory,
                uriAccessory = soDimm._uriAccessory,
                soDimm = soDimm
            )
        )
    }

    coolerForCaseIdsList.forEach { coolerForCase ->
        coolerForCaseList.add(
            CoolerForCase(
                idAccessory = coolerForCase._idAccessory,
                nameAccessory = coolerForCase._nameAccessory,
                priceAccessory = coolerForCase._priceAccessory,
                descriptionAccessory = coolerForCase._descriptionAccessory,
                uriAccessory = coolerForCase._uriAccessory,
                coolerForCase = coolerForCase
            )
        )
    }

    videoCardIdsList.forEach { videoCard ->
        videoCardList.add(
            VideoCard(
                idAccessory = videoCard._idAccessory,
                nameAccessory = videoCard._nameAccessory,
                priceAccessory = videoCard._priceAccessory,
                descriptionAccessory = videoCard._descriptionAccessory,
                uriAccessory = videoCard._uriAccessory,
                videoCard = videoCard
            )
        )
    }

    return Configuration(
        nameConfiguration = this.name,
        cpu = Cpu(
            idAccessory = this.cpuId,
            nameAccessory = cpu._nameAccessory,
            priceAccessory = cpu._priceAccessory,
            descriptionAccessory = cpu._descriptionAccessory,
            uriAccessory = cpu._uriAccessory,
            cpu = cpu
        ),
        motherboard = Motherboard(
            idAccessory = this.motherboardId,
            nameAccessory = motherboard._nameAccessory,
            priceAccessory = motherboard._priceAccessory,
            descriptionAccessory = motherboard._descriptionAccessory,
            uriAccessory = motherboard._uriAccessory,
            motherboard = motherboard
        ),
        powerSupplyUnit = PowerSupplyUnit(
            idAccessory = this.powerSupplyUnitId,
            nameAccessory = powerSupplyUnit._nameAccessory,
            priceAccessory = powerSupplyUnit._priceAccessory,
            descriptionAccessory = powerSupplyUnit._descriptionAccessory,
            uriAccessory = powerSupplyUnit._uriAccessory,
            powerSupplyUnit = powerSupplyUnit
        ),
        coolerForCpu = CoolerForCpu(
            idAccessory = this.coolerForCpuId,
            nameAccessory = powerSupplyUnit._nameAccessory,
            priceAccessory = powerSupplyUnit._priceAccessory,
            descriptionAccessory = powerSupplyUnit._descriptionAccessory,
            uriAccessory = powerSupplyUnit._uriAccessory,
            coolerForCpu = coolerForCpu
        ),
        soundCard = SoundCard(
            idAccessory = this.soundCardId,
            nameAccessory = powerSupplyUnit._nameAccessory,
            priceAccessory = powerSupplyUnit._priceAccessory,
            descriptionAccessory = powerSupplyUnit._descriptionAccessory,
            uriAccessory = powerSupplyUnit._uriAccessory,
            soundCard = soundCard
        ),
        case = Case(
            idAccessory = this.caseId,
            nameAccessory = powerSupplyUnit._nameAccessory,
            priceAccessory = powerSupplyUnit._priceAccessory,
            descriptionAccessory = powerSupplyUnit._descriptionAccessory,
            uriAccessory = powerSupplyUnit._uriAccessory,
            case = case
        ),
        dimmList = dimmList,
        soDimmList = soDimmList,
        videoCardList = videoCardList,
        coolerForCaseList = coolerForCaseList,
        monitorList = monitorList,
        hardDriveList = hardDriveList,
        ssdList = ssdList
    )
}