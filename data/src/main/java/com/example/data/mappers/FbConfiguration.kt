package com.example.data.mappers

data class FbConfiguration(
    var name: String = "",
    var cpuId: String = "",
    var motherboardId: String = "",
    var dimmIdsList: MutableList<String> = mutableListOf(),
    var soDimmIdsList: MutableList<String> = mutableListOf(),
    var powerSupplyUnitId: String = "",
    var soundCardId: String = "",
    var videoCardIdsList: MutableList<String> = mutableListOf(),
    var coolerForCaseIdsList: MutableList<String> = mutableListOf(),
    var coolerForCpuId: String = "",
    var caseId: String = "",
    var monitorIdsList: MutableList<String> = mutableListOf(),
    var hardDriveIdsList: MutableList<String> = mutableListOf(),
    var ssdIdsList: MutableList<String> = mutableListOf(),
    var isFavorite: Boolean = false
)

/*fun FbConfiguration.toConfiguration(
    nameConfiguration: String,
    cpu: com.example.data.model.entities.Cpu,
    motherboard: com.example.data.model.entities.Motherboard,
    powerSupplyUnit: com.example.data.model.entities.PowerSupplyUnit,
    coolerForCpu: com.example.data.model.entities.CoolerForCpu,
    soundCard: com.example.data.model.entities.SoundCard,
    case: com.example.data.model.entities.Case,
    dimmIdsList: MutableList<com.example.data.model.entities.Dimm>,
    soDimmIdsList: MutableList<com.example.data.model.entities.SoDimm>,
    videoCardIdsList: MutableList<com.example.data.model.entities.VideoCard>,
    coolerForCaseIdsList: MutableList<com.example.data.model.entities.CoolerForCase>,
    monitorIdsList: MutableList<com.example.data.model.entities.Monitor>,
    hardDriveIdsList: MutableList<com.example.data.model.entities.HardDrive>,
    ssdIdsList: MutableList<com.example.data.model.entities.Ssd>,
    isFavorite: Boolean
): com.example.data.model.entities.data_class.Configuration {

    var dimmList = mutableListOf<com.example.data.model.entities.Dimm>()
    var soDimmList = mutableListOf<com.example.data.model.entities.SoDimm>()
    var videoCardList = mutableListOf<com.example.data.model.entities.VideoCard>()
    var coolerForCaseList = mutableListOf<com.example.data.model.entities.CoolerForCase>()
    var monitorList = mutableListOf<com.example.data.model.entities.Monitor>()
    var hardDriveList = mutableListOf<com.example.data.model.entities.HardDrive>()
    var ssdList = mutableListOf<com.example.data.model.entities.Ssd>()

    dimmIdsList.forEach { dimm ->
        dimmList.add(
            com.example.data.model.entities.Dimm(
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
            com.example.data.model.entities.Ssd(
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
            com.example.data.model.entities.HardDrive(
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
            com.example.data.model.entities.Monitor(
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
            com.example.data.model.entities.SoDimm(
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
            com.example.data.model.entities.CoolerForCase(
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
            com.example.data.model.entities.VideoCard(
                idAccessory = videoCard._idAccessory,
                nameAccessory = videoCard._nameAccessory,
                priceAccessory = videoCard._priceAccessory,
                descriptionAccessory = videoCard._descriptionAccessory,
                uriAccessory = videoCard._uriAccessory,
                videoCard = videoCard
            )
        )
    }

    return com.example.data.model.entities.data_class.Configuration(
        nameConfiguration = this.name,
        cpu = com.example.data.model.entities.Cpu(
            idAccessory = this.cpuId,
            nameAccessory = cpu._nameAccessory,
            priceAccessory = cpu._priceAccessory,
            descriptionAccessory = cpu._descriptionAccessory,
            uriAccessory = cpu._uriAccessory,
            cpu = cpu
        ),
        motherboard = com.example.data.model.entities.Motherboard(
            idAccessory = this.motherboardId,
            nameAccessory = motherboard._nameAccessory,
            priceAccessory = motherboard._priceAccessory,
            descriptionAccessory = motherboard._descriptionAccessory,
            uriAccessory = motherboard._uriAccessory,
            motherboard = motherboard
        ),
        powerSupplyUnit = com.example.data.model.entities.PowerSupplyUnit(
            idAccessory = this.powerSupplyUnitId,
            nameAccessory = powerSupplyUnit._nameAccessory,
            priceAccessory = powerSupplyUnit._priceAccessory,
            descriptionAccessory = powerSupplyUnit._descriptionAccessory,
            uriAccessory = powerSupplyUnit._uriAccessory,
            powerSupplyUnit = powerSupplyUnit
        ),
        coolerForCpu = com.example.data.model.entities.CoolerForCpu(
            idAccessory = this.coolerForCpuId,
            nameAccessory = powerSupplyUnit._nameAccessory,
            priceAccessory = powerSupplyUnit._priceAccessory,
            descriptionAccessory = powerSupplyUnit._descriptionAccessory,
            uriAccessory = powerSupplyUnit._uriAccessory,
            coolerForCpu = coolerForCpu
        ),
        soundCard = com.example.data.model.entities.SoundCard(
            idAccessory = this.soundCardId,
            nameAccessory = powerSupplyUnit._nameAccessory,
            priceAccessory = powerSupplyUnit._priceAccessory,
            descriptionAccessory = powerSupplyUnit._descriptionAccessory,
            uriAccessory = powerSupplyUnit._uriAccessory,
            soundCard = soundCard
        ),
        case = com.example.data.model.entities.Case(
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
    )*/
